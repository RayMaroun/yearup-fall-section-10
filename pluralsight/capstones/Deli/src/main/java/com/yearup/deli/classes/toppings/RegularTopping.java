package com.yearup.deli.classes.toppings;

import com.yearup.deli.interfaces.Topping;

public class RegularTopping implements Topping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return 0.0; // Included in sandwich price
    }
}
