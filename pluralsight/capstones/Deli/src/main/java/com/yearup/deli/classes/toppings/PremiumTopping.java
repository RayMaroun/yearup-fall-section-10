package com.yearup.deli.classes.toppings;

import com.yearup.deli.interfaces.Topping;

public class PremiumTopping implements Topping {
    private String name;
    private double price;

    public PremiumTopping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
