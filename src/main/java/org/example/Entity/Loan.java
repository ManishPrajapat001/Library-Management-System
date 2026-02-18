package org.example.Entity;

public class Loan {
    private final String loanId;
    private BookCopy bookCopy;
    private Patron borrower;
    private String borrowDate;
    private String submissionDate = null;

    public Loan (String loanId,BookCopy bookCopy,Patron borrower,String borrowDate){
        this.loanId = loanId;
        this.bookCopy = bookCopy;
        this.borrower = borrower;
        this.borrowDate = borrowDate;

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

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getLoanId() {
        return loanId;
    }
}
