package com.yearup.deli.classes.toppings;

import com.yearup.deli.interfaces.Topping;

public class Sauce implements Topping {
    private String name;

    public Sauce(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return 0.0; // Adjust the pricing logic for sauces
    }
}
