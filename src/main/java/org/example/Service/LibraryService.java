package org.example.Service;

import org.example.Entity.BookCopy;
import org.example.Entity.Library;
import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;
import org.example.Repositories.LibraryRepo;
import org.example.Repositories.LoanRepo;
import org.example.Utils.Validator;

public class LibraryService {
    public static void addLibrary(String libraryName,String location) throws InvalidInputException {
        if(libraryName.isEmpty()){
            throw new InvalidInputException("Invalid library name!");
        }

        if (location.isEmpty()){
            throw new InvalidInputException("Invalid loaction!");
        }

        String id = LibraryRepo.addLibrary(libraryName,location);
        System.out.println("Id for this library is " +id);
    }

    public static void closeLibrary(String closingLibraryId,String substituteLibraryId) throws EntityNotFoundException {
        Library closingLib = LibraryRepo.findLibraryById(closingLibraryId);
        if (closingLib == null){
            throw new EntityNotFoundException("Invalid closing library Id!");
        }

        Library substitueLib = LibraryRepo.findLibraryById(substituteLibraryId);
        if (substitueLib == null){
            throw new EntityNotFoundException("Invalid substitute library Id!");
        }

//        transfer whole inventory to substitute
        for (BookCopy bookCopy: closingLib.getAllCopies()){
            substitueLib.addBook(bookCopy);
        }

        LibraryRepo.deleteLibrary(closingLibraryId);
//        Books transfered successfully
        System.out.println("Library with id "+closingLibraryId + " is closed!");
    }
}
