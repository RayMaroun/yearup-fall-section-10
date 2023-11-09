package com.pluralsight;

public class Guest {
    private String name;
    private int age;
    private boolean isCheckedIn;

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCheckedIn = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Check-in and Check-out methods
    public void checkIn() {
        this.isCheckedIn = true;
    }

    public void checkOut() {
        this.isCheckedIn = false;
    }
}
