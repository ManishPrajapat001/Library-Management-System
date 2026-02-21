package org.example.Factory;

import org.example.Entity.BookCopy;
import org.example.Entity.Loan;
import org.example.Entity.Patron;
import org.example.Utils.IdGenerator;

public class LoanFactory {
    private LoanFactory() {
        /* This utility class should not be instantiated */
    }

    public static Loan createLoan(BookCopy bookCopy, Patron patron) {

        if (bookCopy == null || patron == null) {
            throw new IllegalArgumentException("BookCopy and Patron cannot be null");
        }

        String loanId = IdGenerator.generateId("LOAN");

        return new Loan(loanId, bookCopy, patron);
    }
}
