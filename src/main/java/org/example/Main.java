package org.example;

import org.example.Console.ConsoleMenu;

import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            ConsoleMenu.printMenu();

            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1":
                        ConsoleMenu.addBook();
                        break;
                    case "2":
                        ConsoleMenu.addLibrary();
                        break;
                    case "3":
                        ConsoleMenu.addBookCopy();
                        break;
                    case "4":
                        ConsoleMenu.issueBook();
                        break;
                    case "5":
                        ConsoleMenu.submitBook();
                        break;
                    case "6":
                        ConsoleMenu.transferBook();
                        break;
                    case "7":
                        ConsoleMenu.findHistory();
                        break;
                    case "0":
                        System.out.println("Exiting system...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\n--------------------------------\n");
        }
    }
}