package org.example.Entity;

public class BookCopy {
    private final String bookCopyId;
    private final Book book;

    public BookCopy(String bookCopyId, Book book){
        this.bookCopyId = bookCopyId;
        this.book = book;
    }


    public Book getBook() {
        return book;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }
}
