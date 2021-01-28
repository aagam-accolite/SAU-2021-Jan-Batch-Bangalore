package com.accolite.Books.Operation;

import com.accolite.Books.model.Book;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> list;

    BookList(ArrayList<Book> list){
        this.list = list;
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void setList(ArrayList<Book> list) {
        this.list = list;
    }

    public void appendList(ArrayList<Book> list) {
        this.list.addAll(list);
    }
    public void addBook(Book book) {
        this.list.add(book);
    }
    public void listAll() {
        System.out.println("ID\tName\tISBN\tReviewer\tInReview");
        for(Book b : this.list) {
            System.out.println(b.getId() + "\t"+
                    b.getName()+ "\t"+
                    b.getISBN()+ "\t"+
                    b.getReviewer()+ "\t"+
                    b.getInReview());
        }
    }

    public int length() {
        return this.list.size();
    }
}
