package com.accolite.Books.Operation;

import com.accolite.Books.BlockingQueue;
import com.accolite.Books.model.Book;
import com.accolite.Student.model.Student;

import java.util.ArrayList;

public class ShoppingCart implements Runnable {
    private BlockingQueue blockingQueue;
    private Student student;
    private ArrayList<Book> bookList;

    public ShoppingCart(BlockingQueue blockingQueue, Student student, ArrayList<Book> bookList) {
        super();
        this.blockingQueue = blockingQueue;
        this.student = student;
        this.bookList = bookList;
    }

    @Override
    public void run() {
        try {
            System.out.println("\tShopping Cart Class\t");
            for (Book book : bookList) {
                book.getDetails();
                blockingQueue.addToCart(student, book);
            }
            System.out.println("\tItems in Cart\t");
            blockingQueue.listBooks();
            System.out.println();
            Thread t = new Thread(new Buyers(blockingQueue, student, bookList.get(0)));
            t.run();
            bookList.remove(0);
            if (bookList.size() > 0) {
                Thread.sleep(5000);
                for (Book book : bookList) {
                    blockingQueue.removeFromCart(student, book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
