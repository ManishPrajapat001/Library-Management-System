package org.example.Service;

import org.example.Entity.*;
import org.example.Repositories.BookRepo;
import org.example.Repositories.LibraryRepo;
import org.example.Repositories.LoanRepo;
import org.example.Repositories.PatronRepo;

import java.util.Collection;
import java.util.List;

public class LendingService {
    public static void issueBook(String patronId, String ISBN, String libraryId){
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            System.out.println("Invalid patron id!");
            return;
        }

        Library library = LibraryRepo.findLibraryById(libraryId);
        if (library == null){
            System.out.println("Invalid Library Id!");
            return;
        }

        Book book = BookRepo.findByISBN(ISBN);
        if (book == null){
            System.out.println("invalid isbn");
            return;
        }
        Collection<BookCopy> inventory= library.getAllCopies();

        BookCopy physicalBook = null;
        for (BookCopy bookCopy: inventory){
            if (bookCopy.equals(book)){
                LoanRepo.addLoan(bookCopy,patron);
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("The copy of this book is not present in this library!");

//        BookCopy bookCopy =
//        if ()

    }

    public static void submitBook(String patronId,String bookCopyId){
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            System.out.println("Invalid patron id!");
            return;
        }

        Loan loan = LoanRepo.findLoanByBookCopyId(bookCopyId);
        if (loan == null){
            System.out.println("No such book issued.");
            return;
        }

        LoanRepo.submitBook(loan);
        if (loan.getBorrower().equals(patron)){
            System.out.println("Thank you for submiting the book!");
        }
        else {
            System.out.println("This book was not issued to you,but we thank you for returning this book.");

        }
    }

    public static void findHistoryOfPatron(String patronId){

    }

    public static void findAllActiveLoansOfPatron(String patronId){

    }
}
