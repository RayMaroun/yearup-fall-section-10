package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    // Initialize an array of Vehicle objects with a maximum size of 20.
    private static Vehicle[] vehicles = new Vehicle[20];

    // The number of vehicles currently stored in the vehicles array.
    private static int numVehicles = 6;

    // This is the main method where the program execution starts.
    public static void main(String[] args) {

        // Create and initialize some Vehicle objects and store them in the vehicles array.
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00f);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00f);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00f);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00f);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500.00f);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00f);

        // Create a Scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Run a loop until the user quits the program.
        while (true) {

            // Display the options menu to the user.
            System.out.println("What do you want to do?");
            System.out.println("  1 - List all vehicles");
            System.out.println("  2 - Search by make/model");
            System.out.println("  3 - Search by price range");
            System.out.println("  4 - Search by color");
            System.out.println("  5 - Add a vehicle");
            System.out.println("  6 - Quit");
            System.out.println("Enter your command:");

            // Read the user's input command.
            int command = scanner.nextInt();

            // Consume the newline character left in the scanner buffer after reading the command.
            scanner.nextLine();

            // Use a switch statement to call the appropriate method based on the user's input command.
            switch (command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByMakeModel(scanner);
                    break;
                case 3:
                    findVehiclesByPrice(scanner);
                    break;
                case 4:
                    findVehiclesByColor(scanner);
                    break;
                case 5:
                    addVehicle(scanner);
                    break;
                case 6:
                    // Display a message to the user and exit the program.
                    System.out.println("Goodbye!");
                    return;
                default:
                    // Display an error message if the user inputs an invalid command.
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }


    // This method adds a new vehicle to the inventory if there is room for it (maximum of 20 vehicles).
    public static void addVehicle(Scanner scanner) {
        // Check if the inventory is full (max limit is 20)
        if (numVehicles < 20) {

            // Prompt user to enter vehicle ID and read the input
            System.out.print("Enter vehicle ID: ");
            long id = scanner.nextLong();
            scanner.nextLine(); // Consume new line character

            // Prompt user to enter make and model of the vehicle and read the input
            System.out.print("Enter make and model: ");
            String makeModel = scanner.nextLine();

            // Prompt user to enter color of the vehicle and read the input
            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            // Prompt user to enter odometer reading of the vehicle and read the input
            System.out.print("Enter odometer reading: ");
            int odometerReading = scanner.nextInt();

            // Prompt user to enter price of the vehicle and read the input
            System.out.print("Enter price: ");
            float price = scanner.nextFloat();

            // Create a new Vehicle object with the input values
            Vehicle newVehicle = new Vehicle(id, makeModel, color, odometerReading, price);

            // Add the new Vehicle object to the inventory array and increment the number of vehicles counter
            vehicles[numVehicles] = newVehicle;
            numVehicles++;

            // Print a message confirming that the vehicle has been added to the inventory
            System.out.println("Vehicle added.");
        } else {
            // If the inventory is full, print a message indicating that the user cannot add more vehicles
            System.out.println("Vehicle inventory is full");
        }
    }


    // This method is used to list all the vehicles currently in the inventory
    public static void listAllVehicles() {
        // Print a header for the vehicle inventory
        System.out.println("Vehicle inventory:");

        // Iterate over the array of vehicles and print the details of each vehicle
        for (int i = 0; i < numVehicles; i++) {
            //System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
            System.out.println(vehicles[i].toString());
        }
    }

    public static void findVehiclesByMakeModel(Scanner scanner) {
        // Prompt the user to enter the make and model of the vehicle they want to find
        System.out.print("Enter make and model: ");
        String makeModel = scanner.nextLine();

        // Set a boolean variable `found` to false
        boolean found = false;

        // Loop through the vehicles array
        for (int i = 0; i < numVehicles; i++) {
            // If the make and model of the current vehicle matches the user-entered make and model
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                // Print the details of the matching vehicle to the console
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
                // Set `found` to true
                found = true;
            }
        }

        // If no matching vehicle was found, print a message to the console
        if (!found) {
            System.out.println("No vehicles found");
        }
    }

    public static void findVehiclesByPrice(Scanner scanner) {
        // Prompt user to enter minimum price
        System.out.print("Enter minimum price: ");
        float minPrice = scanner.nextFloat();

        // Prompt user to enter maximum price
        System.out.print("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();

        // Set a flag to determine if any matching vehicles were found
        boolean found = false;

        // Loop through the vehicles array
        for (int i = 0; i < numVehicles; i++) {

            // Check if the current vehicle's price is within the given price range
            if (vehicles[i].getPrice() >= minPrice && vehicles[i].getPrice() <= maxPrice) {

                // If the current vehicle's price is within the range, print its details
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());

                // Set the flag to true, indicating at least one matching vehicle was found
                found = true;
            }
        }

        // If no matching vehicles were found, print a message
        if (!found) {
            System.out.println("No vehicles found");
        }
    }


    public static void findVehiclesByColor(Scanner scanner) {
        // Prompt user to enter a color
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        // Initialize a boolean variable to keep track if any vehicles with the entered color are found
        boolean found = false;
        // Iterate through the vehicles array
        for (int i = 0; i < numVehicles; i++) {
            // Check if the current vehicle has the entered color
            if (vehicles[i].getColor().equalsIgnoreCase(color)) {
                // If the vehicle has the entered color, print out its details
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
                // Set found to true to indicate that at least one vehicle with the entered color was found
                found = true;
            }
        }

        // If no vehicles with the entered color were found, print out a message to the user
        if (!found) {
            System.out.println("No vehicles found");
        }
    }
}
