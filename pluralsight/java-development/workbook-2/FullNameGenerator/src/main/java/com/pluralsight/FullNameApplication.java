package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name:");

        System.out.print("First name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Middle name: ");
        String middleName = scanner.nextLine().trim();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Suffix: ");
        String suffix = scanner.nextLine().trim();

        String fullName = firstName;

        if (!middleName.isEmpty()) {
            fullName += " " + middleName.charAt(0) + ".";
        }

        fullName += " " + lastName;

        if (!suffix.isEmpty()) {
            fullName += ", " + suffix;
        }

        System.out.println("\nFull name: " + fullName);

    }
}
