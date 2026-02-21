package org.example.Service;

import org.example.Entity.Book;
import org.example.Entity.BookCopy;
import org.example.Entity.Library;
import org.example.Exception.EntityNotFoundException;
import org.example.Factory.BookCopyFactory;
import org.example.Repositories.BookRepo;
import org.example.Repositories.LibraryRepo;
import org.example.Repositories.LoanRepo;
import org.example.Utils.IdGenerator;

public class InventoryService {
    private InventoryService() {
        /* This utility class should not be instantiated */
    }

    public static void addBookCopyToInventory(String libraryId, String isbn) throws EntityNotFoundException {
        Library library = LibraryRepo.findLibraryById(libraryId);
        if (library == null){
            throw new EntityNotFoundException("Invalid library Id!");
        }

        Book book = BookRepo.findByISBN(isbn);
        if(book == null){
            throw new EntityNotFoundException("Invalid ISBN!");
        }
        BookCopy bookCopy = BookCopyFactory.createBookCopy(library,book);
        library.addBookCopy(bookCopy);

        System.out.println("The copy of this book is added to the library");
    }

    public static void deleteCopy(String libraryId,String bookCopyId) throws EntityNotFoundException {
        Library library = LibraryRepo.findLibraryById(libraryId);
        if (library == null){
            throw new EntityNotFoundException("Invalid library Id!");
        }
        if (library.findBook(bookCopyId)==null){
            throw new EntityNotFoundException("Invalud Bookcopy id!");
        }
        library.removeBook(bookCopyId);
    }

    public static void transferBook(String senderId,String recieverId, String bookCopyId) throws EntityNotFoundException {
        Library senderLib = LibraryRepo.findLibraryById(senderId);
        if (senderLib == null){
            throw new EntityNotFoundException("Invalid library Id!");
        }
        Library recieverLib = LibraryRepo.findLibraryById(recieverId);
        if (recieverLib == null){
            throw new EntityNotFoundException("Invalid library Id!");
        }

        BookCopy bookCopy = senderLib.findBook(bookCopyId);
        if (bookCopy==null){
            throw new EntityNotFoundException("Invalud Bookcopy id!");
        }

        if (LoanRepo.findLoanByBookCopyId(bookCopyId) != null){
            System.out.println("This book is loaned to a patron,so it can't be transfered");
            return;
        }

        senderLib.removeBook(bookCopyId);
        recieverLib.addBookCopy(bookCopy);
        System.out.println("This book  transfered successfully!");

    }
}
