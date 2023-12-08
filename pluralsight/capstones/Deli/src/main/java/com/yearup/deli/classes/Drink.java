package com.yearup.deli.classes;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.0;
        }
    }

    public String getOrderDetails() {
        return "Size: " + size + "\n" + "Flavor: " + flavor + "\n";
    }
}
