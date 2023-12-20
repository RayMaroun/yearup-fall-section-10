package com.pluralsight.demoapi.models;

public class Customer {
    // These are private fields representing customer properties.
    private int id;
    private String name;
    private String address;

    public Customer() {
        // Default constructor for creating an instance without setting fields initially.
    }

    public Customer(int id, String name, String address) {
        // Constructor with parameters to initialize the customer object with specific values.
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Below are getter and setter methods for each field.
    // These methods are used to access (getters) and modify (setters) the private fields of this class.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
