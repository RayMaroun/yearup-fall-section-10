package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Moped slowRide = new Moped("Moped Model", "Red", 50, 5, 1, 10, 100);
        SemiTruck semiTruck = new SemiTruck("SemiTruck Model", "Blue", 120, 200, 2, 500, 2);
        HoverCraft hoverCraft = new HoverCraft("HoverCraft Model", "Yellow", 80, 100, 4, 200, 30);
        Car car = new Car("Car Model", "Silver", 180, 60, 5, 400, 4);

        // Test the functionality of the classes and methods
        slowRide.ride();
        semiTruck.loadCargo();
        hoverCraft.hover();
        car.openTrunk();

        // Accessing Vehicle getters
        System.out.println("Color of the Moped: " + slowRide.getColor());
        System.out.println("Fuel capacity of the SemiTruck: " + semiTruck.getFuelCapacity());
        System.out.println("Air cushion pressure of the HoverCraft: " + hoverCraft.getAirCushionPressure());
        System.out.println("Top speed of the Car: " + car.getTopSpeed());
    }
}
