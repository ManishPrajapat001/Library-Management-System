package org.example.Entity;

public class Book {
    private String title;
    private String Author;
    private String ISBN;
    private String year;

    public Book(String title, String author, String year, String ISBN) {
        this.title = title;
        this.Author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
