package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable {
    private String name;
    private double value;

    public FixedAsset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public abstract double getValue();
}
