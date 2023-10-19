package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {
    // the key is the product id, the value is a product object
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        loadInventory();

        Scanner scanner = new Scanner(System.in);
        boolean keepSearching = true;

        while (keepSearching) {
            System.out.print("What item # are you interested in? ");
            int id = scanner.nextInt();

            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
            } else {
                System.out.printf("We carry %s and the price is $%.2f\n",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.print("Do you want to go again? (y/n): ");
            String answer = scanner.next();
            keepSearching = answer.equalsIgnoreCase("y");
        }
    }

    private static void loadInventory() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                inventory.put(id, new Product(id, name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
