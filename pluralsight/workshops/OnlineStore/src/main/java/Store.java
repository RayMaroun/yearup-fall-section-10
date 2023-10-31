import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) {
        ArrayList<Product> inventory = new ArrayList<Product>();
        ArrayList<Product> cart = new ArrayList<Product>();
        double totalAmount = 0.0;
        loadInventory("products.csv", inventory);

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayProducts(inventory, cart, scanner);
                    break;
                case 2:
                    displayCart(cart, scanner, totalAmount);
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");
                Product product = new Product(fields[0], fields[1], Double.parseDouble(fields[2]));
                inventory.add(product);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }

    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        System.out.println("Products:");
        for (Product product : inventory) {
            System.out.println(product.getId() + " " + product.getName() + " $" + product.getPrice());
        }
        System.out.println("Enter product ID to add to cart or X to go back to home screen:");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("X")) {
            return;
        } else {
            Product product = findProductById(choice,inventory);
            if (product != null) {
                cart.add(product);
                System.out.println("Added " + product.getName() + " to cart!");
                return;
            } else {
                System.out.println("Invalid product ID!");
                return;
            }
        }
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        System.out.println("Cart:");
        for (Product product : cart) {
            System.out.println(product.getName() + " $" + product.getPrice());
            totalAmount += product.getPrice();
        }
        System.out.println("Total amount: $" + totalAmount);
        System.out.println("C - Check Out");
        System.out.println("X - Go back to home screen");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("C")) {
            checkOut(cart, totalAmount);
        } else if (choice.equalsIgnoreCase("X")) {
            return;
        } else {
            System.out.println("Invalid choice!");
            return;
        }
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        System.out.println("Total amount owed: $" + totalAmount);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment amount: $");
        double payment = scanner.nextDouble();
        if (payment < totalAmount) {
            System.out.println("Payment amount is not enough!");
            return;
        } else {
            double change = payment - totalAmount;
            System.out.println("Change: $" + change);
            System.out.println("Items sold:");
            for (Product product : cart) {
                System.out.println(product.getName() + " $" + product.getPrice());
            }
            cart.clear();
            totalAmount = 0.0;
            return;
        }
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        for (Product product : inventory) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }
}
