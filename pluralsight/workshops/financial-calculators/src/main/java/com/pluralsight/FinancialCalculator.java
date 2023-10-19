package com.pluralsight;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FinancialCalculator {

    private static Scanner scanner = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {

        System.out.println("Welcome to the Financial Calculator!");

        while (true) {
            System.out.println("\nPlease select a calculator:");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator");
            System.out.println("3. Present Value Calculator");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mortgageCalculator();
                    break;
                case 2:
                    futureValueCalculator();
                    break;
                case 3:
                    presentValueCalculator();
                    break;
                case 4:
                    System.out.println("Thank you for using the Financial Calculator!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void mortgageCalculator() {
        System.out.println("\nWelcome to the Mortgage Calculator!");

        // Prompt user for inputs
        System.out.print("Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Interest rate (in %): ");
        double interestRate = scanner.nextDouble() / 100.0 / 12.0; // convert to monthly interest rate

        System.out.print("Loan length (in years): ");
        int years = scanner.nextInt();
        int months = years * 12; // convert to number of months

        // Calculate monthly payment
        double numerator = principal * interestRate * Math.pow(1 + interestRate, months);
        double denominator = Math.pow(1 + interestRate, months) - 1;
        double monthlyPayment = numerator / denominator;

        // Calculate total interest paid
        double totalInterest = monthlyPayment * months - principal;

        // Display results
        System.out.printf("Your monthly payment will be $%.2f\n", monthlyPayment);
        System.out.printf("You will pay a total of $%.2f in interest\n", totalInterest);
    }

    private static void futureValueCalculator() {
        System.out.println("\nWelcome to the Future Value Calculator!");

        // Prompt user for inputs
        System.out.print("Deposit amount: ");
        double deposit = scanner.nextDouble();

        System.out.print("Interest rate (in %): ");
        double interestRate = scanner.nextDouble() / 100.0;

        System.out.print("Number of years: ");
        int years = scanner.nextInt();

        // Calculate future value
        double futureValue = deposit * Math.pow(1 + interestRate, years);

        // Calculate total interest earned
        double totalInterest = futureValue - deposit;

        // Display results
        System.out.printf("Your deposit will be worth $%.2f after %d years\n", futureValue, years);
        System.out.printf("You will earn a total of $%.2f in interest\n", totalInterest);
    }

    private static void presentValueCalculator() {
        System.out.println("\nWelcome to the Present Value Calculator!");

        // Prompt user for inputs
        System.out.print("Monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.print("Expected interest rate (in %): ");
        double interestRate = scanner.nextDouble() / 100.0 / 12.0; // convert to monthly interest rate

        System.out.print("Number of years: ");
        int years = scanner.nextInt();

        // Calculate present value
        double numerator = monthlyPayout * (1 - Math.pow(1 + interestRate, -years * 12));
        double denominator = interestRate;
        double presentValue = numerator / denominator;
        // Display result
        System.out.printf("The present value of your investment is $%.2f\n", presentValue);
    }
}

