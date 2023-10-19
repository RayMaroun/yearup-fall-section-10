package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        // Bonus 1
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        // Print the inventory
        for (Product product : inventory) {
            System.out.println(product);
        }

        // Bonus 3
        Scanner input = new Scanner(System.in);
        int command = 0;

        while (command != 5) {
            System.out.println("What do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- Lookup a product by its id");
            System.out.println("3- Find all products within a price range");
            System.out.println("4- Add a new product");
            System.out.println("5- Quit the application");

            System.out.print("Enter command: ");
            command = input.nextInt();

            switch (command) {
                case 1:
                    listAllProducts(inventory);
                    break;
                case 2:
                    lookupProductById(inventory);
                    break;
                case 3:
                    findProductsByPriceRange(inventory);
                    break;
                case 4:
                    addNewProduct(inventory);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    private static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // Bonus 2
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                inventory.add(new Product(id, name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add products to the inventory
        /*inventory.add(new Product(1, "Shirt", 19.99));
        inventory.add(new Product(2, "Pants", 29.99));
        inventory.add(new Product(3, "Shoes", 49.99));
        inventory.add(new Product(4, "Hat", 14.99));
        inventory.add(new Product(5, "Jacket", 79.99));*/

        return inventory;
    }

    private static void listAllProducts(ArrayList<Product> inventory) {
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    private static void lookupProductById(ArrayList<Product> inventory) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product id: ");
        int id = input.nextInt();

        for (Product product : inventory) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }

        System.out.println("Product not found.");
    }

    private static void findProductsByPriceRange(ArrayList<Product> inventory) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = input.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = input.nextDouble();

        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
            }
        }
    }

    private static void addNewProduct(ArrayList<Product> inventory) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter product name: ");
        String name = input.nextLine();
        System.out.print("Enter product price: ");
        double price = input.nextDouble();
        inventory.add(new Product(id, name, price));
    }
}
