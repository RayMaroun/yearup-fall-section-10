package com.pluralsight;

import com.pluralsight.finance.*;

import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a portfolio
        Portfolio portfolio = new Portfolio("My Portfolio", "John");

        while (true) {
            System.out.println("Enter the type of asset (Jewelry, Gold, House, BankAccount, CreditCard) or 'quit' to exit:");
            String assetType = scanner.nextLine();

            if (assetType.equalsIgnoreCase("quit")) {
                break;
            }

            switch (assetType.toLowerCase()) {
                case "jewelry":
                    System.out.println("Enter the karat value:");
                    double karat = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Jewelry jewelry = new Jewelry(karat);
                    portfolio.add(jewelry);
                    break;
                case "gold":
                    System.out.println("Enter the weight:");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Gold gold = new Gold(weight);
                    portfolio.add(gold);
                    break;
                case "house":
                    System.out.println("Enter the year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter the square feet:");
                    int squareFeet = scanner.nextInt();
                    System.out.println("Enter the bedrooms number:");
                    int bedrooms = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    House house = new House(year,squareFeet,bedrooms);
                    portfolio.add(house);
                    break;
                case "bankaccount":
                    System.out.println("Enter the bank account owner name:");
                    String bankAccountOwner = scanner.nextLine();
                    System.out.println("Enter the bank account number:");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter the balance:");
                    double bankAccountBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    BankAccount bankAccount = new BankAccount(bankAccountOwner, accountNumber, bankAccountBalance);
                    portfolio.add(bankAccount);
                    break;
                case "creditcard":
                    System.out.println("Enter the credit card owner name:");
                    String creditCardOwner = scanner.nextLine();
                    System.out.println("Enter the credit card number:");
                    String creditCardAccountNumber = scanner.nextLine();
                    System.out.println("Enter the balance:");
                    double creditCardBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    CreditCard creditCard = new CreditCard(creditCardOwner,creditCardAccountNumber, creditCardBalance);
                    portfolio.add(creditCard);
                    break;
                default:
                    System.out.println("Invalid asset type. Please try again.");
                    break;
            }
        }

        // Print the portfolio value
        double portfolioValue = portfolio.getValue();
        System.out.println("Portfolio Value: $" + portfolioValue);

        // Get the most valuable asset
        Valuable mostValuableAsset = portfolio.getMostValuable();
        System.out.println("Most Valuable Asset(Value: " + mostValuableAsset.getValue() + "): " + mostValuableAsset);

        // Get the least valuable asset
        Valuable leastValuableAsset = portfolio.getLeastValuable();
        System.out.println("Least Valuable Asset(Value: " + leastValuableAsset.getValue() + "): " + leastValuableAsset);
    }
}
