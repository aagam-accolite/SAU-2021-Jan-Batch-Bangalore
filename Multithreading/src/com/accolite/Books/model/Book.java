package com.accolite.Books.model;

public class Book {
    private String name;
    private int id;
    private String ISBN;
    private String Reviewer;
    private Boolean isInReview;
    private Boolean isInCart;

    public Book(String name, int id, String ISBN, String Reviewer, Boolean isInReview, Boolean isInCart) {
        super();
        this.name = name;
        this.id = id;
        this.ISBN = ISBN;
        this.Reviewer = Reviewer;
        this.isInReview = isInReview;
        this.isInCart = isInCart;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Boolean getInReview() {
        return isInReview;
    }

    public void setInReview(Boolean inReview) {
        isInReview = inReview;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
    }

    public Boolean getInCart() {
        return isInCart;
    }

    public void setInCart(Boolean inCart) {
        isInCart = inCart;
    }

    public void getDetails() {
        System.out.println(this.getId() + "\t" +
                this.getName() + "\t" +
                this.getISBN() + "\t" +
                this.getReviewer() + "\t" +
                this.getInReview() + "\t"+
                this.getInCart() + "\t");
    }
}
