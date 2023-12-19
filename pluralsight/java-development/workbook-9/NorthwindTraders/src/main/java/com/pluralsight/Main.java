package com.pluralsight;

import com.pluralsight.models.Product;
import com.pluralsight.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ProductService productService = context.getBean(ProductService.class);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========== Northwind Traders ==========");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    listProducts(productService);
                    break;
                case 2:
                    addProduct(scanner, productService);
                    break;
                case 3:
                    updateProduct(scanner, productService);
                    break;
                case 4:
                    deleteProduct(scanner, productService);
                    break;
                case 5:
                    searchProduct(scanner, productService);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void listProducts(ProductService productService) {
        System.out.println("========== List of Products ==========");
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();
    }

    private static void addProduct(Scanner scanner, ProductService productService) {
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = new Product(productId, name, category, price);
        productService.addProduct(product);

        System.out.println("Product added successfully.\n");
    }

    private static void updateProduct(Scanner scanner, ProductService productService) {
        System.out.print("Enter the product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product existingProduct = productService.getProductById(productId);
        if (existingProduct == null) {
            System.out.println("Product not found.\n");
            return;
        }

        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();

        Product updatedProduct = new Product(productId, name, category, price);
        productService.updateProduct(updatedProduct);

        System.out.println("Product updated successfully.\n");
    }

    private static void deleteProduct(Scanner scanner, ProductService productService) {
        System.out.print("Enter the product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product existingProduct = productService.getProductById(productId);
        if (existingProduct == null) {
            System.out.println("Product not found.\n");
            return;
        }

        productService.deleteProduct(existingProduct);

        System.out.println("Product deleted successfully.\n");
    }

    private static void searchProduct(Scanner scanner, ProductService productService) {
        System.out.print("Enter the product ID to search: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product product = productService.getProductById(productId);
        if (product == null) {
            System.out.println("Product not found.\n");
        } else {
            System.out.println("========== Product Details ==========");
            System.out.println(product);
            System.out.println();
        }
    }
}
