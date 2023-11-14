package com.pluralsight.finance;

public class House extends FixedAsset {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(int yearBuilt, int squareFeet, int bedrooms) {
        super("House", 0);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }


    @Override
    public double getValue() {
        double baseValue = 0; // Set the base value for House
        return baseValue + 10000; // Dummy value for illustration
    }

    @Override
    public String toString() {
        return "House{" +
                "yearBuilt=" + yearBuilt +
                ", squareFeet=" + squareFeet +
                ", bedrooms=" + bedrooms +
                '}';
    }
}
