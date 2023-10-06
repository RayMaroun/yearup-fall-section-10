package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants for prices and discounts
        final double REGULAR_PRICE = 5.45;
        final double LARGE_PRICE = 8.95;
        final double LOADED_PRICE_REGULAR = 1.0;
        final double LOADED_PRICE_LARGE = 1.75;
        final double STUDENT_DISCOUNT = 0.1;
        final double SENIOR_DISCOUNT = 0.2;

        // Prompt for sandwich size
        System.out.println("Select sandwich size (1=Regular, 2=Large): ");
        int sandwichSize = input.nextInt();

        // Calculate base price and loaded price
        double basePrice = sandwichSize == 1 ? REGULAR_PRICE : LARGE_PRICE;
        double loadedPrice = sandwichSize == 1 ? LOADED_PRICE_REGULAR : LOADED_PRICE_LARGE;

        // Prompt for loaded option
        System.out.println("Do you want the sandwich loaded? (yes/no): ");
        String loadedOption = input.next();
        boolean isLoaded = loadedOption.equalsIgnoreCase("yes");

        // Add loaded price if applicable
        if (isLoaded) {
            basePrice += loadedPrice;
        }

        // Prompt for age and calculate discount
        System.out.println("Enter your age: ");
        int age = input.nextInt();
        double discount = 0.0;
        if (age <= 17) {
            discount = STUDENT_DISCOUNT;
        } else if (age >= 65) {
            discount = SENIOR_DISCOUNT;
        }

        // Calculate final price with discount
        double finalPrice = basePrice * (1 - discount);

        // Display results
        System.out.println("Sandwich cost: $" + finalPrice);
    }
}


