package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println(
                        "Application needs two arguments to run: " + "java com.hca.jdbc.UsingDriverManager <username> " +
                                "<password>");
                System.exit(1);
            }

            // get the user name and password from the command line args
            String username = args[0];
            String password = args[1];

            // load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    username,
                    password);

            // define your query with placeholders for parameters
            String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

            // 2. Create a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);

            // 3. Execute the PreparedStatement and obtain the ResultSet
            ResultSet results = statement.executeQuery();

            // process the results
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Units In Stock: " + unitsInStock);
                System.out.println("-----------------------------------------");
            }

            // 4. Close the connection and release resources
            results.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
