package org.example.Service;

import org.example.Entity.*;
import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;
import org.example.Repositories.BookRepo;
import org.example.Repositories.LibraryRepo;
import org.example.Repositories.LoanRepo;
import org.example.Repositories.PatronRepo;

import java.util.Collection;

public class LendingService {
    private LendingService() {
        /* This utility class should not be instantiated */
    }

    public static void issueBook(String patronId, String ISBN, String libraryId) throws InvalidInputException, EntityNotFoundException {
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            throw new EntityNotFoundException("Invalid patron id!");
        }

        Library library = LibraryRepo.findLibraryById(libraryId);
        if (library == null){
            throw new EntityNotFoundException("Invalid Library Id!");
        }

        Book book = BookRepo.findByISBN(ISBN);
        if (book == null){
            throw new EntityNotFoundException("invalid ISBN!");
        }
        Collection<BookCopy> inventory= library.getAllCopies();



        BookCopy physicalBook = null;
        for (BookCopy bookCopy: inventory){
            if (bookCopy.getBook().getISBN().equals(book.getISBN())){
                //        if book on already loan

                if(LoanRepo.findLoanByBookCopyId(bookCopy.getBookCopyId()) == null){
                    LoanRepo.addLoan(bookCopy,patron);
                    System.out.println("Book borrowed successfully!");
                    return;
                }
                else {
                    System.out.println("Book is already Borrowed by someone else");
                }

            }
        }
        System.out.println("The copy of this book is not present in this library!");



    }

    public static void submitBook(String patronId,String bookCopyId) throws EntityNotFoundException{
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            throw new EntityNotFoundException("Invalid patron id!");
        }

        Loan loan = LoanRepo.findLoanByBookCopyId(bookCopyId);
        if (loan == null){
            throw new EntityNotFoundException("No such book issued.");
        }

        LoanRepo.submitBook(loan);
        if (loan.getBorrower().equals(patron)){
            System.out.println("Thank you for submiting the book!");
        }
        else {
            System.out.println("This book was not issued to you,but we thank you for returning this book.");

        }
    }

    public static void findHistoryOfPatron(String patronId) throws EntityNotFoundException{
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            throw new EntityNotFoundException("Invalid patron id!");
        }

        Collection<Loan> history = LoanRepo.findHistory(patronId);
        System.out.println("History of Patron with patron_id:" + patronId);
        for(Loan loan :history){
            loan.displayInfo();
        }
    }

    public static void findAllActiveLoansOfPatron(String patronId) throws EntityNotFoundException {
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            throw new EntityNotFoundException("Invalid patron id!");
        }

        Collection<Loan> activeLoans = LoanRepo.findActiveLoans(patronId);
        System.out.println("Active Loans of Patron with patron_id:" + patronId);
        for(Loan loan : activeLoans){
            loan.displayInfo();
        }
    }
}
