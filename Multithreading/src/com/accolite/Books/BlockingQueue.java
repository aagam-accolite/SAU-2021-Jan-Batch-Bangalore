package com.accolite.Books;

import com.accolite.Books.Operation.BookList;
import com.accolite.Books.model.Book;
import com.accolite.Student.model.Student;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private BookList bookList;
    private Lock lock = new ReentrantLock();
    private Condition addBookCondition = lock.newCondition();
    private Condition buyerCondition = lock.newCondition();
    private ArrayList<Book> blockingQueue = new ArrayList<Book>();
    private int bookCount = 0;

    public ArrayList<Book> listBooks() {
        System.out.println("\tList of Books\t");
        for (Book b : blockingQueue) {
            try {
                b.getDetails();
            } catch (Exception e) {
            }
        }
        return blockingQueue;
    }

    public void removeFromCart(Student student, Book book) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < blockingQueue.size(); i++) {
                if (blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInCart(false);
                    blockingQueue.get(i).setReviewer("Library");
                    break;
                }
            }
            addBookCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addToCart(Student student, Book book) throws InterruptedException {
        lock.lock();
        try {
            if (student.doesOwnBook(book)) {
                System.out.println("Error : Book already in use / Cannot Add Book");
                return;
            }
            for (int i = 0; i < blockingQueue.size(); i++) {
                if (blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInCart(true);
                    blockingQueue.get(i).setReviewer("(" + student.getId() + " : " + student.getName() + ")");
                    break;
                }
            }
            addBookCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public void put(Book book) throws InterruptedException {
        lock.lock();
        try {
            blockingQueue.add(book);
            bookCount++;
            buyerCondition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public Object review(Student student, Book book) throws InterruptedException {
        lock.lock();
        try {
            if (book == null) {
                System.out.println("No Book Exist");
                return null;
            }
            while (bookCount == 0) {
                buyerCondition.await();
            }
            if (student.doesOwnBook(book)) {
                System.out.println("Error: Cannot be in Review");
                return null;
            }
            for (int i = 0; i < blockingQueue.size(); i++) {
                if (blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInReview(true);
                    blockingQueue.get(i).setReviewer("(" + student.getId() + " : " + student.getName() + ")");
                    student.addReviewBook(blockingQueue.get(i));
                    break;
                }
            }
            addBookCondition.signalAll();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public Object checkout(Student student, Book book) throws InterruptedException {
        lock.lock();
        try {
            while (bookCount == 0) {
                buyerCondition.await();
            }
            if (student.doesOwnBook(book)) {
                System.out.println("Error : Student owns the Book");
                return null;
            }
            for (int i = 0; i < blockingQueue.size(); i++) {
                if (blockingQueue.get(i).getId() == book.getId() && blockingQueue.get(i).getISBN() == book.getISBN()) {
                    blockingQueue.get(i).setInReview(true);
                    blockingQueue.get(i).setReviewer("(" + student.getId() + " : " + student.getName()+ ")");
                    student.addBoughtBook(blockingQueue.get(i));
                    blockingQueue.remove(i);
                    break;
                }
            }
            System.out.println("Book Issued from Library");
            addBookCondition.signalAll();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
