package org.example.Repositories;

import org.example.Entity.Patron;
import org.example.Utils.IdGenerator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PatronRepo {
    private static Map<String, Patron> patronList= new HashMap<>();

    public static String addPatron(String name, LocalDate dateOfBirth, String address, String phoneNumber, String email){
        String id = IdGenerator.generateId("PATRON");
        Patron patron = new Patron(id,name,dateOfBirth,address,phoneNumber,email);
        patronList.put(id,patron);
        return patron.getPatronId();
    }

    public static void removePatron(String patronId){
        patronList.remove(patronId);
    }

    public static Patron getPatronById(String patronId){
        return patronList.get(patronId);
    }
}
