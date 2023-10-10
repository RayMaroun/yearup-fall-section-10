package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their full name
        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine();

        int indexOfSpace = fullName.indexOf(" ");
        String firstName = fullName.substring(0, indexOfSpace);
        String lastName = fullName.substring(indexOfSpace + 1);

        // Prompt the user for the date of the show
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String dateStr = scanner.nextLine();

        // Parse the date using DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        // Prompt the user for the number of tickets
        System.out.print("How many tickets would you like? ");
        int numTickets = scanner.nextInt();

        // Display the confirmation message
        String ticketString = numTickets == 1 ? " ticket" : " tickets";
        String confirmationMessage = numTickets + ticketString + " reserved for " + date + " under " + lastName + ", " + firstName;
        System.out.println(confirmationMessage);

        scanner.close();
    }
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().trim();
        // Prompt user for date
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String dateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        System.out.print("How many tickets would you like? ");
        int numTickets = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline character

        String[] nameParts = name.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];


        String ticketStr = numTickets == 1 ? "1 ticket" : numTickets + " tickets";
        String confirmation = String.format("%s reserved for %s under %s, %s",
                ticketStr, date, lastName, firstName);
        System.out.println(confirmation);
    }*/
}
