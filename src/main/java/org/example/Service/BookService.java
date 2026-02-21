package org.example.Service;

import org.example.Entity.Book;
import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;
import org.example.Repositories.BookRepo;
import org.example.Repositories.LibraryRepo;

import java.util.Collection;

public class BookService {

    private BookService() {
        /* This utility class should not be instantiated */
    }

    public static String addNewBook(String isbn, String title, String author, String publicationYear)
            throws InvalidInputException {

        if (isbn == null || isbn.isBlank()) {
            throw new InvalidInputException("ISBN cannot be empty.");
        }

        if (BookRepo.findByISBN(isbn) != null) {
            throw new InvalidInputException("Book with this ISBN already exists.");
        }

        BookRepo.addBook(isbn, title, author, publicationYear);

        return "Book added successfully.";
    }

    public static Book findBookByISBN(String isbn) throws EntityNotFoundException {
        Book book = BookRepo.findByISBN(isbn);
        if (book == null) {
            throw new EntityNotFoundException("Book not found.");
        }
        return book;
    }

    public static Collection<Book> getAllBooks() {
        return BookRepo.getAllBooks();
    }

    public static void deleteBook(String isbn) throws EntityNotFoundException {

        Book book = BookRepo.findByISBN(isbn);
        if (book == null) {
            throw new EntityNotFoundException("Book not found.");
        }

        // IMPORTANT: ensure no copies exist in any library
        boolean existsInInventory = LibraryRepo.isBookPresentInAnyLibrary(isbn);

        if (existsInInventory) {
            throw new IllegalStateException("Cannot delete book. Copies still exist in inventory.");
        }

        BookRepo.deleteBook(isbn);
    }
}