package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for sandwich size
        System.out.print("Enter sandwich size (1 for Regular, 2 for Large): ");
        int sandwichSize = scanner.nextInt();

        // Calculate base price
        double basePrice;
        if (sandwichSize == 1) {
            basePrice = 5.45;
        } else if (sandwichSize == 2) {
            basePrice = 8.95;
        } else {
            System.out.println("Invalid sandwich size");
            return;
        }

        // Prompt user for age
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        // Calculate discount percentage
        double discountPercentage = 0.0;
        if (age <= 17) {
            discountPercentage = 0.1;
        } else if (age >= 65) {
            discountPercentage = 0.2;
        }

        // Calculate final price
        double finalPrice = basePrice * (1 - discountPercentage);

        // Display cost of sandwich
        System.out.printf("Cost of sandwich: $%.2f%n", finalPrice);

        scanner.close();
    }
}


