package com.accolite.Books.Operation;

import com.accolite.Books.BlockingQueue;
import com.accolite.Books.model.Book;

public class AddBooks implements Runnable {

    private BlockingQueue blockingQueue;
    private String[] name;
    private int[] id;
    private String[] ISBN;
    private Boolean[] isOwned;
    private Boolean[] isInCart;

    public AddBooks(BlockingQueue bbq, String[] name, int[] id, String[] ISBN, Boolean[] isOwned, Boolean[] isInCart) {
        super();
        this.blockingQueue = bbq;
        this.name = name;
        this.id = id;
        this.ISBN = ISBN;
        this.isOwned = isOwned;
        this.isInCart = isInCart;
    }

    @Override
    public void run() {
        for (int i = 0; i < id.length; i++) {
            Book b = new Book(this.name[i],
                    this.id[i],
                    this.ISBN[i],
                    new String("Library - College"),
                    this.isOwned[i],
                    this.isInCart[i]);
            try {
                blockingQueue.put(b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
