package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        // Create house objects
        House house1 = new House("My House", "2021-01-01", 200000.0, "123 Main St", 1, 2000, 5000);
        House house2 = new House("Vacation Home", "2022-05-01", 300000.0, "456 Beach Rd", 2, 1500, 10000);

        // Create vehicle objects
        Vehicle vehicle1 = new Vehicle("My Car", "2020-01-01", 25000.0, "Toyota Camry", 2021, 50000);
        Vehicle vehicle2 = new Vehicle("Tom's Truck", "2018-06-01", 35000.0, "Ford F-150", 2019, 80000);

        // Add assets to the list
        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);

        // Display asset information
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Year: " + vehicle.getYear());
            }
            System.out.println("Value: $" + asset.getValue());
            System.out.println();
        }
    }
}