package com.yearup.dealership;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("dealership.csv"))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                if (lineNumber == 0) { // dealership info
                    String name = fields[0];
                    String address = fields[1];
                    String phone = fields[2];
                    dealership = new Dealership(name, address, phone);
                } else { // vehicle info
                    int vin = Integer.parseInt(fields[0]);
                    int year = Integer.parseInt(fields[1]);
                    String make = fields[2];
                    String model = fields[3];
                    String vehicleType = fields[4];
                    String color = fields[5];
                    int odometer = Integer.parseInt(fields[6]);
                    double price = Double.parseDouble(fields[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    vehicles.add(vehicle);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dealership != null) {
            for (Vehicle vehicle : vehicles) {
                dealership.addVehicle(vehicle);
            }
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dealership.csv"))) {
            // Write dealership information
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();

            // Write vehicle inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                        + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                        + "|" + vehicle.getPrice());
                bw.newLine();
            }

            System.out.println("Dealership saved successfully to dealership.csv.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

