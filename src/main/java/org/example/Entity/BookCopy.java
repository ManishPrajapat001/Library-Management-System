package org.example.Entity;

public class BookCopy {
    private final String bookId;
    private final Book book;

    BookCopy(String bookId, Book book){
        this.bookId = bookId;
        this.book = book;
    }


    public Book getBook() {
        return book;
    }

    public String getBookId() {
        return bookId;
    }
}
