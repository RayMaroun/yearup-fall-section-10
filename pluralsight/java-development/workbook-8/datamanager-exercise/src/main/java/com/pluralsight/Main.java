package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("User and password are needed to connect to the database");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        DataManager dataManager = new DataManager(basicDataSource);

        List<Product> productList = dataManager.getAllProducts();

        //productList.forEach(System.out::println);

        for (Product product : productList) {
            printProduct(product);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a Product ID: ");
        int productID = scanner.nextInt();

        Product product = dataManager.getProductById(productID);

        printProduct(product);

    }
    
    public static void printProduct(Product product) {
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Unit Price: " + product.getUnitPrice());
        System.out.println("Units In Stock: " + product.getUnitsInStock());
        System.out.println("================================================");
    }

}
