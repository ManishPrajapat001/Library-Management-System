package org.example.Repositories;

import org.example.Entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookRepo {
    private static Map<String, Book> bookInventory;

    public static Map<String, Book> getBookInventory() {
        return bookInventory;
    }
    public static Book findByISBN(String ISBN){
        return bookInventory.get(ISBN);
    }
    public static void addBook(String title, String author, String year, String ISBN){
        Book book = new Book(title,author,year,ISBN);
        bookInventory.put(ISBN,book);

    }

    public static void removeBook(String ISBN){
        bookInventory.remove(ISBN);
    }

    public static List<Book> searchByTitle(String title){
        List<Book> bookList = new ArrayList<>();

        for(Book book:bookInventory.values()){
            if(Objects.equals(book.getTitle(), title)){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public static List<Book> searchByAuthor(String author){
        List<Book> bookList = new ArrayList<>();
        for(Book book:bookInventory.values()){
            if(Objects.equals(book.getTitle(), author)){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
