package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a BasicDataSource
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");

        // Use try-with-resources to automatically close the connection and statement
        try (Connection connection = dataSource.getConnection();
             Scanner scanner = new Scanner(System.in)) {
            // Ask the user for a last name of an actor
            System.out.print("Enter the last name of an actor: ");
            String lastName = scanner.nextLine();

            // Execute query to retrieve actors with the provided last name
            String actorsQuery = "SELECT first_name, last_name FROM actor WHERE last_name = ?";
            try (PreparedStatement actorsStatement = connection.prepareStatement(actorsQuery)) {
                actorsStatement.setString(1, lastName);

                try (ResultSet actorsResult = actorsStatement.executeQuery()) {
                    if (actorsResult.next()) {
                        System.out.println("Your matches are: \n");
                        do {
                            String firstName = actorsResult.getString("first_name");
                            lastName = actorsResult.getString("last_name");
                            System.out.println(firstName + " " + lastName);
                        } while (actorsResult.next());
                    } else {
                        System.out.println("No matches!");
                    }
                }
            }

            // Ask the user for a first name and last name of an actor
            System.out.print("\nEnter the first name of an actor: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter the last name of an actor: ");
            lastName = scanner.nextLine();

            // Execute query to retrieve films the actor has been in
            String filmsQuery = "SELECT title FROM film f JOIN film_actor fa ON f.film_id = fa.film_id " +
                    "JOIN actor a ON fa.actor_id = a.actor_id " +
                    "WHERE a.first_name = ? AND a.last_name = ?";
            try (PreparedStatement filmsStatement = connection.prepareStatement(filmsQuery)) {
                filmsStatement.setString(1, firstName);
                filmsStatement.setString(2, lastName);

                try (ResultSet filmsResult = filmsStatement.executeQuery()) {
                    if (filmsResult.next()) {
                        System.out.println("\nThe films the actor has been in: \n");
                        do {
                            String filmTitle = filmsResult.getString("title");
                            System.out.println(filmTitle);
                        } while (filmsResult.next());
                    } else {
                        System.out.println("\nNo films found for the actor!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
