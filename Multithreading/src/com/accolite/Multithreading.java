package com.accolite;

import com.accolite.Books.BlockingQueue;
import com.accolite.Books.Operation.AddBooks;
import com.accolite.Books.Operation.BookReviewer;
import com.accolite.Books.Operation.ShoppingCart;
import com.accolite.Books.model.Book;
import com.accolite.Student.model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Multithreading {
    private static ArrayList<Student> studentList = new ArrayList<Student>();
    private static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void initStudents() {
        String[] name = {"Ram", "Shyam", "Bharat", "Darshan", "Raj", "Ved", "Rahul", "Samir", "Somil", "Devansh"};
        int[] id = {1, 2, 1, 2, 3, 1, 1, 2, 3, 4};
        String[] department = {"Computer Science", "Computer Science", "Electronics", "Information Tech", "Information Tech", "Computer Science", "Mechanical", "Mechanical", "Electronics", "Information Tech"};

        for (int i = 0; i < 10; i++) {
            Student b = new Student(name[i], id[i], department[i]);
            studentList.add(b);
        }
        System.out.println("\tStudents Added Sucessfully\t");
    }

    private static void initBooks(BlockingQueue blockingQueue) {
        String[] name = {"Java for Dummies", "Java for Dummies", "Big Data", "Big Data", "Cyber Security", "Cyber Security", "CS with Python", "CS with Python", "CS with Python", "CS with Python"};
        int[] id = {1, 2, 1, 2, 3, 1, 1, 2, 3, 4};
        String[] ISBN = {"1001", "1001", "1002", "1002", "1003", "1003", "1004", "1004", "1004", "1004"};
        Boolean isOwned[] = new Boolean[10];
        Boolean isInCart[] = new Boolean[10];
        Arrays.fill(isOwned,false);
        Arrays.fill(isInCart,false);

        Thread initializingBookList = new Thread(new AddBooks(blockingQueue, name, id, ISBN, isOwned, isInCart));
        initializingBookList.run();
    }

    public static void main(String[] args) {
        initStudents();
        BlockingQueue blockingQueue = new BlockingQueue();
        initBooks(blockingQueue);

        bookList = blockingQueue.listBooks();

        String[] booksToBeBought = {"1001"};
        Thread transcation1 = new Thread(new ShoppingCart(blockingQueue, studentList.get(0), findBookByISBN(booksToBeBought)));
        transcation1.run();

        booksToBeBought = new String[]{"1004", "1003", "1002"};

        System.out.println("\tAdding Multiple Books\t");
        System.out.println();
        Thread transcation2 = new Thread(new ShoppingCart(blockingQueue, studentList.get(4), findBookByISBN(booksToBeBought)));
        transcation2.run();

        addNewBooks(blockingQueue);

        booksToBeBought = new String[]{"1005"};
        Thread transcation3 = new Thread(new ShoppingCart(blockingQueue, studentList.get(4), findBookByISBN(booksToBeBought)));
        transcation3.run();
        blockingQueue.listBooks();

        String[] bookToBeReviewed = {"1004"};
        Thread transcation4 = new Thread(new BookReviewer(blockingQueue, studentList.get(2), findBookByISBN(bookToBeReviewed)));
        transcation4.run();

        bookToBeReviewed = new String[]{"1001"};
        Thread transcation5 = new Thread(new BookReviewer(blockingQueue, studentList.get(6), findBookByISBN(bookToBeReviewed)));
        transcation5.run();

        System.out.println();
        System.out.println("Books bought by students");
        for (Student student : studentList) {
            student.getBoughtBooks();
            student.getReviewBooks();
        }
        blockingQueue.listBooks();

    }

    private static ArrayList<Book> findBookByISBN(String[] isbnList) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (String isbn : isbnList) {
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getISBN() == isbn && !bookList.get(i).getInReview() && !bookList.get(i).getInCart()) {
                    books.add(bookList.get(i));
                    break;
                }
            }
        }
        return books;
    }

    public static void addNewBooks(BlockingQueue blockingQueue) {
        String[] nameNew = {"Android"};
        int[] idNew = {5};
        String[] ISBNNew = {"1005"};
        Boolean[] isOwnedNew = {false};
        Boolean[] isInCart = {false};
        Thread addNewBookList = new Thread(new AddBooks(blockingQueue, nameNew, idNew, ISBNNew, isOwnedNew, isInCart));
        addNewBookList.run();
        System.out.println();
        System.out.println("Library Inventory");
        System.out.println("ID\tName\tISBN\tOwner\tisOwned");
        blockingQueue.listBooks();
    }


}
