package Main;

import db.DataManager;
import models.Shipper;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = args[0];
        String password = args[1];

        DataManager dataManager = new DataManager(url, username, password);
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for new shipper data
        System.out.print("Enter the shipper's name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter the shipper's phone number: ");
        String phoneNumber = scanner.nextLine();

        dataManager.insertShipper(companyName, phoneNumber);

        // Display all shippers
        System.out.println("\nAll Shippers:");
        List<Shipper> shippers = dataManager.getAllShippers();
        for (Shipper shipper : shippers) {
            System.out.println("Shipper ID: " + shipper.getShipperId());
            System.out.println("Company Name: " + shipper.getCompanyName());
            System.out.println("Phone Number: " + shipper.getPhoneNumber());
            System.out.println();
        }

        // Prompt the user to change the phone number of a shipper
        System.out.print("Enter the shipper ID to update the phone number: ");
        int shipperId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the new phone number: ");
        phoneNumber = scanner.nextLine();

        dataManager.updateShipperPhoneNumber(shipperId, phoneNumber);

        // Display all shippers again
        System.out.println("\nAll Shippers after update:");
        shippers = dataManager.getAllShippers();
        for (Shipper shipper : shippers) {
            System.out.println("Shipper ID: " + shipper.getShipperId());
            System.out.println("Company Name: " + shipper.getCompanyName());
            System.out.println("Phone Number: " + shipper.getPhoneNumber());
            System.out.println();
        }

        // Prompt the user to delete a shipper
        System.out.print("Enter the shipper ID to delete: ");
        shipperId = scanner.nextInt();

        dataManager.deleteShipper(shipperId);

        // Display all shippers again
        System.out.println("\nAll Shippers after deletion:");
        shippers = dataManager.getAllShippers();
        for (Shipper shipper : shippers) {
            System.out.println("Shipper ID: " + shipper.getShipperId());
            System.out.println("Company Name: " + shipper.getCompanyName());
            System.out.println("Phone Number: " + shipper.getPhoneNumber());
            System.out.println();
        }

        scanner.close();
    }
}

