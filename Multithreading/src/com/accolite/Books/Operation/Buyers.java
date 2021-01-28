package com.accolite.Books.Operation;

import com.accolite.Books.BlockingQueue;
import com.accolite.Books.model.Book;
import com.accolite.Student.model.Student;

public class Buyers implements Runnable {

    private BlockingQueue blockingQueue;
    private Student student;
    private Book book;

    public Buyers(BlockingQueue blockingQueue, Student student, Book book) {
        super();
        this.blockingQueue = blockingQueue;
        this.student = student;
        this.book= book;
    }
    @Override
    public void run() {
        try {
            blockingQueue.checkout(student,book);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
