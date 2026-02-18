package org.example.Repositories;

import org.example.Entity.Library;
import org.example.Utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepo {
    private static Map<String, Library> libraryList = new HashMap<>();//key is libraryId

    public static String addLibrary(String libraryName,String location){
        String id = IdGenerator.generateId("LIBRARY");
        Library library = new Library(id,libraryName,location);
        libraryList.put(id,library);
        return id;
    }

    public static void deleteLibrary(String libraryId){
        libraryList.remove(libraryId);
    }
    public static Library findLibraryById(String libraryId){
        return libraryList.get(libraryId);
    }
}
