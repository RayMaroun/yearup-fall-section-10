package com.pluralsight.turtlepaint;

public abstract class Shape {
    private Turtle turtle;
    private Point location;
    private String color;
    private int border;

    public Shape(Turtle turtle, Point location, String color, int border) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.border = border;
    }

    public Turtle getTurtle() {
        return turtle;
    }

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public abstract void paint();
}
