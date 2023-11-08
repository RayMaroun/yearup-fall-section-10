package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue() {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        double value = 0.0;
        if (age <= 3) {
            for (int i = 0; i < age; i++) {
                value = 0.97 * getOriginalCost();
            }
        } else if (age <= 6) {
            for (int i = 0; i < age; i++) {
                value = 0.94 * getOriginalCost();
            }
        } else if (age <= 10) {
            for (int i = 0; i < age; i++) {
                value = 0.92 * getOriginalCost();
            }
        } else {
            value = getOriginalCost() - 1000.00;
        }

        if (!(makeModel.contains("Honda") || makeModel.contains("Toyota"))
                && odometer > 100000) {
            value *= 0.75;
        }

        return value;
    }
}