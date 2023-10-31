package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Book[] inventory = new Book[5];
        inventory[0] = new Book(1, "9780671023379", "The Alchemist by Paulo Coelho");
        inventory[1] = new Book(2, "9780061120084", "To Kill a Mockingbird by Harper Lee");
        inventory[2] = new Book(3, "9780143132172", "The 7 Habits of Highly Effective People by Stephen Covey");
        inventory[3] = new Book(4, "9781984801906", "Atomic Habits by James Clear");
        inventory[4] = new Book(5, "9780062562851", "The Four Agreements by Don Miguel Ruiz");

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("Store Home Screen");
            System.out.println("------------------");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAvailableBooks(inventory, scanner);
                    break;
                case 2:
                    displayCheckedOutBooks(inventory, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private static void displayAvailableBooks(Book[] inventory, Scanner scanner) {
        System.out.println("Available Books");
        System.out.println("------------------");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println("Id: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
        System.out.println("------------------");
        System.out.println("Enter the Id of the book you want to check out or press 0 to exit: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        if (bookId == 0) {
            return;
        } else if (bookId < 1 || bookId > inventory.length) {
            System.out.println("Invalid book Id!");
            return;
        }
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Book selectedBook = inventory[bookId - 1];
        if (selectedBook.isCheckedOut()) {
            System.out.println("Sorry, this book is already checked out!");
        } else {
            selectedBook.checkOut(name);
            System.out.println("Thank you, " + name + "! You have successfully checked out " + selectedBook.getTitle() + ".");
        }
    }

    private static void displayCheckedOutBooks(Book[] inventory, Scanner scanner) {
        System.out.println("Checked Out Books");
        System.out.println("------------------");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println("Id: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked out to: " + book.getCheckedOutTo());
            }
        }
        System.out.println("------------------");
        System.out.println("Press C to check in a book, or X to go back to the home screen: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("C")) {
            System.out.print("Enter the Id of the book you want to check in: ");
            int id = scanner.nextInt();
            if (id < 1 || id > inventory.length) {
                System.out.println("Invalid book Id!");
                return;
            }
            Book book = inventory[id - 1];
            if (!book.isCheckedOut()) {
                System.out.println("This book is not checked out!");
                return;
            }
            book.checkIn();
            System.out.println("Thank you for returning " + book.getTitle() + ".");
        } else if (input.equalsIgnoreCase("X")) {
            return;
        } else {
            System.out.println("Invalid input!");
        }
    }

}
