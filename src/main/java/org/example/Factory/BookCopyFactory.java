package org.example.Factory;

import org.example.Entity.*;
import org.example.Exception.EntityNotFoundException;
import org.example.Repositories.BookRepo;
import org.example.Repositories.LibraryRepo;
import org.example.Utils.IdGenerator;


public class BookCopyFactory {
    private BookCopyFactory() {
        /* This utility class should not be instantiated */
    }

    public static BookCopy createBookCopy(Library library,Book book) throws EntityNotFoundException {


        if (library == null || book == null){
            throw new IllegalArgumentException("Library or book can't be empty!");
        }


        String id= IdGenerator.generateId("BOOKCOPY");
        return new BookCopy(id,book);
    }
}
