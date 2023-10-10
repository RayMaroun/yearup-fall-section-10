package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their name
        System.out.print("Please enter your name: ");
        String input = scanner.nextLine().trim();

        // Initialize variables to store the first, middle, and last names
        String firstName = "";
        String middleName = "";
        String lastName = "";

        // Find the first space
        int firstSpaceIndex = input.indexOf(' ');

        if (firstSpaceIndex == -1) {
            // If there is only one word, it's the first and last name
            firstName = input;
            lastName = input;
        } else {
            // Extract the first name
            firstName = input.substring(0, firstSpaceIndex);

            // Remove the first name and any leading/trailing spaces
            input = input.substring(firstSpaceIndex).trim();

            // Find the last space (if any) in the remaining input
            int lastSpaceIndex = input.lastIndexOf(' ');

            if (lastSpaceIndex == -1) {
                // If there's no last space, the remaining input is the last name
                lastName = input;
            } else {
                // Extract the middle and last names
                middleName = input.substring(0, lastSpaceIndex);
                lastName = input.substring(lastSpaceIndex + 1);
            }
        }

        // Display the individual pieces of the name
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + (middleName.isEmpty() ? "(none)" : middleName));
        System.out.println("Last name: " + lastName);

        scanner.close();
    }


    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter name
        System.out.print("Please enter your name: ");
        String name = input.nextLine().trim(); // Trim leading/trailing spaces

        // Split name into parts
        String[] parts = name.split(" "); // Split by whitespace

        // Determine number of parts and extract first/last name
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        String middleName = "";

        if (parts.length == 3) { // First, middle, last name format
            middleName = parts[1];
        }

        // Display name parts
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }*/
}
