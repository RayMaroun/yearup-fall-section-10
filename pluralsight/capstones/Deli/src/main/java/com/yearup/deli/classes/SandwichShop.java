package com.yearup.deli.classes;

import com.yearup.deli.classes.toppings.PremiumTopping;
import com.yearup.deli.classes.toppings.RegularTopping;
import com.yearup.deli.classes.toppings.Sauce;

import java.util.Scanner;

public class SandwichShop {
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder;

    public static void main(String[] args) {
        showHomeScreen();
    }

    private static void showHomeScreen() {
        System.out.println("DELI-cious Sandwich Shop");
        System.out.println("1) New Order");
        System.out.println("0) Exit");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                startNewOrder();
                break;
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showHomeScreen();
        }
    }

    private static void startNewOrder() {
        currentOrder = new Order();
        showOrderScreen();
    }

    private static void showOrderScreen() {
        System.out.println("\nOrder Screen");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                addSandwich();
                break;
            case 2:
                addDrink();
                break;
            case 3:
                addChips();
                break;
            case 4:
                checkout();
                break;
            case 0:
                currentOrder = null;
                showHomeScreen();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showOrderScreen();
        }
    }

    private static void addSandwich() {
        System.out.println("\nAdd Sandwich");

        System.out.println("Select your bread:");
        String bread = getUserInput();

        System.out.println("Sandwich size (4\", 8\", 12\"): ");
        String size = getUserInput();

        Sandwich sandwich = new Sandwich(bread, size);
        customizeSandwich(sandwich, size);
        currentOrder.addSandwich(sandwich);

        showOrderScreen();
    }

    private static void customizeSandwich(Sandwich sandwich, String size) {
        System.out.println("Toppings:");
        System.out.println("Meat Options: steak, ham, salami, roast beef, chicken, bacon");
        String meat;
        do {
            meat = getUserInput();
            if (!meat.isEmpty()) {
                sandwich.addTopping(new PremiumTopping(meat, getPremiumToppingMeatPrice(size)));
            }
        } while (!meat.isEmpty());

        System.out.println("Cheese Options: american, provolone, cheddar, swiss");
        String cheese;
        do {
            cheese = getUserInput();
            if (!cheese.isEmpty()) {
                sandwich.addTopping(new PremiumTopping(cheese, getPremiumToppingCheesePrice(size)));
            }
        } while (!cheese.isEmpty());

        System.out.println("Other toppings:");
        String topping;
        do {
            topping = getUserInput();
            if (!topping.isEmpty()) {
                sandwich.addTopping(new RegularTopping(topping));
            }
        } while (!topping.isEmpty());

        System.out.println("Extra meat? (Yes/No)");
        String extraMeat = getUserInput();
        if (extraMeat.equalsIgnoreCase("Yes")) {
            double extraMeatPrice = getExtraMeatPrice(size);
            sandwich.addTopping(new PremiumTopping("Extra Meat", extraMeatPrice));
        }

        System.out.println("Extra cheese? (Yes/No)");
        String extraCheese = getUserInput();
        if (extraCheese.equalsIgnoreCase("Yes")) {
            double extraCheesePrice = getExtraCheesePrice(size);
            sandwich.addTopping(new PremiumTopping("Extra Cheese", extraCheesePrice));
        }

        System.out.println("Select sauces:");
        String sauce;
        do {
            sauce = getUserInput();
            if (!sauce.isEmpty()) {
                sandwich.addTopping(new Sauce(sauce));
            }
        } while (!sauce.isEmpty());

        System.out.println("Would you like the sandwich toasted? (Yes/No)");
        String toasted = getUserInput();
        sandwich.setToasted(toasted.equalsIgnoreCase("Yes"));
    }

    private static double getExtraMeatPrice(String size) {
        switch (size) {
            case "4\"":
                return 0.50;
            case "8\"":
                return 1.00;
            case "12\"":
                return 1.50;
            default:
                return 0.0;
        }
    }

    private static double getExtraCheesePrice(String size) {
        switch (size) {
            case "4\"":
                return 0.30;
            case "8\"":
                return 0.60;
            case "12\"":
                return 0.90;
            default:
                return 0.0;
        }
    }

    private static void addDrink() {
        System.out.println("\nAdd Drink");

        System.out.println("Drink size (Small, Medium, Large): ");
        String size = getUserInput();

        System.out.println("Flavor: ");
        String flavor = getUserInput();

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        showOrderScreen();
    }

    private static void addChips() {
        System.out.println("\nAdd Chips");

        System.out.println("Chip type: ");
        String type = getUserInput();

        Chips chip = new Chips(type);
        currentOrder.addChip(chip);

        showOrderScreen();
    }

    private static void checkout() {
        System.out.println("\nCheckout");
        System.out.println("Order Details:\n");

        // Display order details and pricing
        for (Sandwich sandwich : currentOrder.getSandwiches()) {
            System.out.println(sandwich.getOrderDetails());
            System.out.println("Price: $" + sandwich.calculatePrice());
            System.out.println();
        }
        for (Drink drink : currentOrder.getDrinks()) {
            System.out.println(drink.getOrderDetails());
            System.out.println("Price: $" + drink.getPrice());
            System.out.println();
        }
        for (Chips chip : currentOrder.getChips()) {
            System.out.println(chip.getOrderDetails());
            System.out.println("Price: $" + chip.getPrice());
            System.out.println();
        }

        System.out.println("Total Price: $" + currentOrder.calculateTotalPrice());

        System.out.println("\n1) Confirm");
        System.out.println("2) Cancel");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                currentOrder.createReceiptFile();
                currentOrder = null;
                showHomeScreen();
                break;
            case 2:
                showHomeScreen();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                checkout();
        }
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String getUserInput() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    private static double getPremiumToppingMeatPrice(String size) {
        switch (size) {
            case "4\"":
                return 1.00;
            case "8\"":
                return 2.00;
            case "12\"":
                return 3.00;
            default:
                return 0.0;
        }
    }

    private static double getPremiumToppingCheesePrice(String size) {
        switch (size) {
            case "4\"":
                return 0.75;
            case "8\"":
                return 1.50;
            case "12\"":
                return 2.25;
            default:
                return 0.0;
        }
    }
}