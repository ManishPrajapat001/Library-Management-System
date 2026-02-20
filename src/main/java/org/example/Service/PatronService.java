package org.example.Service;

import org.example.Entity.Patron;
import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;
import org.example.Repositories.LoanRepo;
import org.example.Repositories.PatronRepo;
import org.example.Utils.Validator;

import java.time.LocalDate;

public class PatronService {

    public static void addPatron(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email) throws InvalidInputException {
        if(name == null || name.isEmpty()){
            throw new InvalidInputException("Name is not given");
        }

        if (!dateOfBirth.isBefore(LocalDate.now())){
            throw new InvalidInputException("Invaild Date of Birth");
        }

        if (address == null || address.isEmpty()){
            throw new InvalidInputException("Invalid Address");
        }

        if (!Validator.isValidNumber(phoneNumber)){
            throw new InvalidInputException("Invalid phone number");
        }

        if (!Validator.isValidEmail(email)){
            throw new InvalidInputException("Invalid Email Id");
        }

        String id =PatronRepo.addPatron(name,dateOfBirth,address,phoneNumber,email);
        System.out.println("Patron Added successfully!,Your id is :"+id);
    }

    public static void removePatron(String patronId) throws EntityNotFoundException {
        Patron patron = PatronRepo.getPatronById(patronId);
        if (patron == null){
            throw new EntityNotFoundException("Patron not found!");
        }

        if (LoanRepo.isActiveLoanOnPatron(patronId)){
            throw new EntityNotFoundException("Patron have existing loan,clear these before closing account!");
        }

        PatronRepo.removePatron(patronId);
        System.out.println("Patron Your account has been deleted successfully!");
    }
}
