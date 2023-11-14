package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(double weight) {
        super("Gold", 0); // Set initial value to 0 for Gold
        this.weight = weight;
    }

    @Override
    public double getValue() {
        // Add your specific calculation for Gold value here
        double baseValue = 0; // Set the base value for Gold
        // Calculate the value based on weight and current market rate
        return baseValue + (weight * 100);
    }

    @Override
    public String toString() {
        return "Gold{" +
                "weight=" + weight +
                '}';
    }
}
