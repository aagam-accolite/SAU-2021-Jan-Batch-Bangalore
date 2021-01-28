package com.accolite.Books.Operation;

import com.accolite.Books.BlockingQueue;
import com.accolite.Books.model.Book;
import com.accolite.Student.model.Student;

import java.util.ArrayList;

public class BookReviewer implements Runnable{

    private Student student;
    private ArrayList<Book> book;
    private BlockingQueue blockingQueue;

    public BookReviewer(BlockingQueue blockingQueue, Student student, ArrayList<Book> book) {
        super();
        this.blockingQueue = blockingQueue;
        this.student = student;
        this.book= book;
    }
    @Override
    public void run() {
        try {
            blockingQueue.review(student,book.get(0));;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
