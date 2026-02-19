package org.example.Repositories;

import org.example.Entity.BookCopy;
import org.example.Entity.Loan;
import org.example.Entity.Patron;
import org.example.Utils.IdGenerator;

import java.time.LocalDate;
import java.util.*;

public class LoanRepo {
    private static Map<String, Loan> activeLoans = new HashMap<>();//bookCopyId
    private static Map<String, List<Loan>> loanHistory = new HashMap<>();//key is patronId


    public static void addLoan(BookCopy bookCopy, Patron borrower){
        if(activeLoans.get(bookCopy.getBookId()) != null){
            return;
        }
        String id = IdGenerator.generateId("LOAN");
        Loan loan = new Loan(id,bookCopy,borrower);
        activeLoans.put(id,loan);
    }

    public static void submitBook(Loan loan){
        BookCopy bookCopy = loan.getBookCopy();
        if(activeLoans.get(bookCopy.getBookId()) == null){
            return;
        }
        activeLoans.remove(bookCopy.getBookId());
        loan.setSubmissionDate(LocalDate.now());

        Patron patron = loan.getBorrower();
        List<Loan> listOfLoans = loanHistory.get(patron.getPatronId());
        if(listOfLoans == null){
            listOfLoans = new ArrayList<>();
            loanHistory.put(patron.getPatronId(), listOfLoans);
        }
        listOfLoans.add(loan);
    }

    public static boolean isActiveLoan(String patronId){
        for (List<Loan>loans : loanHistory.values()){
            for (Loan loan : loans){
                if (Objects.equals(loan.getBorrower().getPatronId(), patronId)){
                    return true;
                }
            }
        }
        return false;
    }

    public static Loan findLoanByBookCopyId(String bookCopyId){
        return activeLoans.get(bookCopyId);
    }
}
