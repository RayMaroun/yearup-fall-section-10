package com.yearup.deli.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }
        for (Chips chip : chips) {
            totalPrice += chip.getPrice();
        }
        return totalPrice;
    }

    public void createReceiptFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String fileName = timestamp + ".txt";

        String folderPath = "receipts";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Receipts folder created.");
            } else {
                System.out.println("Failed to create receipts folder.");
                return;
            }
        }

        try (FileWriter writer = new FileWriter(folderPath + "/" + fileName)) {
            StringBuilder receipt = new StringBuilder();
            receipt.append("Order Details:\n\n");
            receipt.append("Sandwiches:\n\n");
            for (Sandwich sandwich : sandwiches) {
                receipt.append(sandwich.getOrderDetails());
                receipt.append("Price: $").append(sandwich.calculatePrice()).append("\n\n");
            }
            receipt.append("Drinks:\n\n");
            for (Drink drink : drinks) {
                receipt.append(drink.getOrderDetails());
                receipt.append("Price: $").append(drink.getPrice()).append("\n\n");
            }
            receipt.append("Chips:\n\n");
            for (Chips chip : chips) {
                receipt.append(chip.getOrderDetails());
                receipt.append("Price: $").append(chip.getPrice()).append("\n\n");
            }
            receipt.append("Total Price: $").append(calculateTotalPrice()).append("\n");

            writer.write(receipt.toString());
            System.out.println("Receipt created: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to create receipt.");
        }
    }
}