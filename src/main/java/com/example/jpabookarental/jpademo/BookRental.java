package com.example.jpabookarental.jpademo;


import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BookRental
{
    @Id
    private int isbn;

    @NotEmpty
    @Size(min=5,message = "author name should not be null")
    private String authorName;

    @NotEmpty
    @Size(min=5,message = "bookTitle should not be null")
    private String bookTitle;

    private boolean isAcademic;

    private int stock;

    public BookRental() {
    }

    public BookRental(String authorName, String bookTitle, boolean isAcademic, int stock) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.isAcademic = isAcademic;
        this.stock = stock;
    }

    public int getIsbn() {
        return this.isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isAcademic() {
        return this.isAcademic;
    }

    public void setAcademic(boolean academic) {
        isAcademic = academic;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "BookRental{" +
                "isbn=" + isbn +
                ", authorName='" + authorName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", isAcademic=" + isAcademic +
                ", stock=" + stock +
                '}';
    }
}
