package org.example.Repositories;

import org.example.Entity.Loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanRepo {
    private static Map<String, Loan> activeLoans = new HashMap<>();//bookCopyId
    private static Map<String, List<Loan>> loanHistory = new HashMap<>();//key is patronId
}
