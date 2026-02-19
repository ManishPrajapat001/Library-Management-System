package org.example.Service;

import org.example.Entity.Patron;
import org.example.Repositories.LoanRepo;
import org.example.Repositories.PatronRepo;
import org.example.Utils.Validator;

import java.time.LocalDate;

public class PatronService {

    public static void addPatron(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email){
        if(name == null || name.isEmpty()){
            System.out.println("Name is not given");
            return;
        }

        if (!dateOfBirth.isBefore(LocalDate.now())){
            System.out.println("Invaild Date of Birth");
            return;
        }

        if (address == null || address.isEmpty()){
            System.out.println("Invalid Address");
            return;
        }

        if (!Validator.isValidNumber(phoneNumber)){
            System.out.println("Invalid phone number");
            return;
        }

        if (!Validator.isValidEmail(email)){
            System.out.println("Invalid Email Id");
            return;
        }

        PatronRepo.addPatron(name,dateOfBirth,address,phoneNumber,email);
    }

    public static void removePatron(String patronId){
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            System.out.println("Invalid Patron ID!");
            return;
        }

        if (LoanRepo.isActiveLoan(patronId)){
            System.out.println("Patron have existing loan,clear these before closing account!");
            return;
        }

        PatronRepo.removePatron(patronId);
        System.out.println("Patron Your account has been deleted successfully!");
    }
}
