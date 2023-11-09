package com.pluralsight;

public class Staff {
    private String name;
    private String position;
    private int id;

    public Staff(String name, String position, int id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String performDuty(String dutyDescription) {
        return name + " is performing duty: " + dutyDescription;
    }
}
