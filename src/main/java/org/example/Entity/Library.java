package org.example.Entity;

import java.util.*;

public class Library {
    private final String libraryId;
    private String libraryName;
    private String location;
    private Map<String,BookCopy> inventory;//key will be bookCopyId

    public Library(String libraryId,String libraryName,String location){

        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.location = location;
        this.inventory = new HashMap<>();
    }
    public String getLibraryId() {
        return libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<BookCopy> getAllCopies() {
        return Collections.unmodifiableCollection(inventory.values());
    }


    public void addBook(BookCopy bookCopy) {
        this.inventory.put(bookCopy.getBookId(),bookCopy);
    }

    public void removeBook(String bookId) {
        this.inventory.remove(bookId);
    }
}
