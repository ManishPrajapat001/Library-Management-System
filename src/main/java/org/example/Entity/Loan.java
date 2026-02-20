package org.example.Entity;

import java.time.LocalDate;

public class Loan {
    private final String loanId;
    private BookCopy bookCopy;
    private Patron borrower;
    private final LocalDate borrowDate;
    private LocalDate submissionDate = null;

    public Loan (String loanId,BookCopy bookCopy,Patron borrower){
        this.loanId = loanId;
        this.bookCopy = bookCopy;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();

    }
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Patron getBorrower() {
        return borrower;
    }

    public void setBorrower(Patron borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }


    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void displayInfo() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Book Title: " + bookCopy.getBook().getTitle());
        System.out.println("Copy ID: " + bookCopy.getBookCopyId());
        System.out.println("Borrower: " + borrower.getName());
        System.out.println("Borrow Date: " + borrowDate);

        if (submissionDate == null) {
            System.out.println("Status: Not Returned Yet");
        } else {
            System.out.println("Submission Date: " + submissionDate);
        }

        System.out.println("----------------------------");
    }
}
