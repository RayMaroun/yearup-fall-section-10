package com.yearup.deli.classes;

import com.yearup.deli.classes.toppings.Sauce;
import com.yearup.deli.interfaces.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private String size;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.size = size;
        toppings = new ArrayList<>();
        toasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double calculatePrice() {
        double totalPrice = 0.0;
        switch (size) {
            case "4\"":
                totalPrice += 5.50;
                break;
            case "8\"":
                totalPrice += 7.00;
                break;
            case "12\"":
                totalPrice += 8.50;
                break;
        }
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Bread: ").append(bread).append("\n");
        details.append("Size: ").append(size).append("\n");
        details.append("Toppings: ").append("\n");
        for (Topping topping : toppings) {
            if (!(topping instanceof Sauce)) {
                details.append("- ").append(topping.getName()).append("\n");
            }
        }

        // Include sauces separately
        details.append("Sauces: ").append("\n");
        for (Topping topping : toppings) {
            if (topping instanceof Sauce) {
                details.append("- ").append(topping.getName()).append("\n");
            }
        }

        details.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");
        return details.toString();
    }
}
