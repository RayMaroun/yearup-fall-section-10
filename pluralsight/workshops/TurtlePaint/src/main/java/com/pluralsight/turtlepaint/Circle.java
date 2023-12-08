package com.pluralsight.turtlepaint;

import java.awt.*;
import java.lang.reflect.Field;

public class Circle extends Shape {
    private int radius;

    public Circle(Turtle turtle, Point location, String color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        Turtle turtle = getTurtle();

        turtle.setDelay(0.00);

        turtle.setPenWidth(getBorder());

        Color color;
        try {
            // Get the field corresponding to the color name
            Field field = Color.class.getField(getColor().toUpperCase());
            // Retrieve the value (Color object) of the field
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Color not found or error occurred
        }
        turtle.setColor(color);

        int numSides = 50;
        double sideLength = (2 * Math.PI * radius) / numSides; // length of each side of the polygon

        for (int i = 0; i < numSides; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(360.0 / numSides);
        }
    }
}
