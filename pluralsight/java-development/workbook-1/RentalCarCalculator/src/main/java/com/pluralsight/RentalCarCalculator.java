package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {

    public static void main(String[] args) {

        // constants for fees
        final double CAR_RENTAL_RATE = 29.99;
        final double TOLL_TAG_RATE = 3.95;
        final double GPS_RATE = 2.95;
        final double ROADSIDE_ASSISTANCE_RATE = 3.95;
        final double UNDERAGE_DRIVER_SURCHARGE = 0.3;

        // get user inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Enter pickup date (mm/dd/yyyy): ");
        String pickupDate = input.nextLine();
        System.out.print("Enter number of rental days: ");
        int rentalDays = input.nextInt();
        input.nextLine(); // consume newline character
        System.out.print("Do you want an electronic toll tag (y/n)? ");
        String tollTagInput = input.nextLine().toLowerCase();
        boolean tollTag = tollTagInput.equals("y") || tollTagInput.equals("yes");
        System.out.print("Do you want a GPS (y/n)? ");
        String gpsInput = input.nextLine().toLowerCase();
        boolean gps = gpsInput.equals("y") || gpsInput.equals("yes");
        System.out.print("Do you want roadside assistance (y/n)? ");
        String roadsideAssistanceInput = input.nextLine().toLowerCase();
        boolean roadsideAssistance = roadsideAssistanceInput.equals("y") || roadsideAssistanceInput.equals("yes");
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        // calculate costs
        double carRentalCost = CAR_RENTAL_RATE * rentalDays;
        double optionsCost = 0.0;
        if (tollTag) {
            optionsCost += TOLL_TAG_RATE * rentalDays;
        }
        if (gps) {
            optionsCost += GPS_RATE * rentalDays;
        }
        if (roadsideAssistance) {
            optionsCost += ROADSIDE_ASSISTANCE_RATE * rentalDays;
        }
        double underageDriverSurcharge = 0.0;
        if (age < 25) {
            underageDriverSurcharge = carRentalCost * UNDERAGE_DRIVER_SURCHARGE;
        }
        double totalCost = carRentalCost + optionsCost + underageDriverSurcharge;

        // display results
        System.out.println("\nRental Summary");
        System.out.println("--------------");
        System.out.println("Pickup date: " + pickupDate);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Car rental rate: $" + CAR_RENTAL_RATE + " per day");
        System.out.println("Options cost: $" + String.format("%.2f", optionsCost));
        if (age < 25) {
            System.out.println("Underage driver surcharge: $" + String.format("%.2f", underageDriverSurcharge));
        }
        System.out.println("Total cost: $" + String.format("%.2f", totalCost));
    }
}
