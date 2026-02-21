package org.example.Console;

import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;

import java.util.Scanner;
import org.example.Service.BookService;
import org.example.Service.InventoryService;
import org.example.Service.LendingService;
import org.example.Service.LibraryService;

public class ConsoleMenu {
    static Scanner sc = new Scanner(System.in);
    public static void printMenu() {
        System.out.println("====== Library Management System ======");
        System.out.println("1. Add New Book");
        System.out.println("2. Add Library Branch");
        System.out.println("3. Add Book Copy To Library");
        System.out.println("4. Issue Book");
        System.out.println("5. Submit Book");
        System.out.println("6. Transfer Book Copy");
        System.out.println("7. Find Patron Loan History");
        System.out.println("0. Exit");
    }

    public static void addBook() throws InvalidInputException {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Publication Year: ");
        String year = sc.nextLine();

        BookService.addNewBook(isbn, title, author, year);
        System.out.println("Book added successfully.");
    }

    public static void addLibrary() throws InvalidInputException {
        System.out.print("Enter Library Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        String id = LibraryService.addLibrary(name, location);
        System.out.println("Library added with ID: " + id);
    }

    public static void addBookCopy() throws EntityNotFoundException {
        System.out.print("Enter Library ID: ");
        String libraryId = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        InventoryService.addBookCopyToInventory(libraryId, isbn);
    }

    public static void issueBook() throws Exception {
        System.out.print("Enter Patron ID: ");
        String patronId = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter Library ID: ");
        String libraryId = sc.nextLine();

        LendingService.issueBook(patronId, isbn, libraryId);
    }

    public static void submitBook() throws EntityNotFoundException {
        System.out.print("Enter Patron ID: ");
        String patronId = sc.nextLine();

        System.out.print("Enter Book Copy ID: ");
        String copyId = sc.nextLine();

        LendingService.submitBook(patronId, copyId);
    }

    public static void transferBook() throws EntityNotFoundException {
        System.out.print("Enter Sender Library ID: ");
        String sender = sc.nextLine();

        System.out.print("Enter Receiver Library ID: ");
        String receiver = sc.nextLine();

        System.out.print("Enter Book Copy ID: ");
        String copyId = sc.nextLine();

        InventoryService.transferBook(sender, receiver, copyId);
    }

    public static void findHistory() throws EntityNotFoundException {
        System.out.print("Enter Patron ID: ");
        String patronId = sc.nextLine();

        LendingService.findHistoryOfPatron(patronId);
    }
}
