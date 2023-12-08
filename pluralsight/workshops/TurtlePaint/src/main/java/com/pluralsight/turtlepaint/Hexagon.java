package com.pluralsight.turtlepaint;

import java.awt.*;
import java.lang.reflect.Field;

public class Hexagon extends Shape {
    private int sideLength;

    public Hexagon(Turtle turtle, Point location, String color, int border, int sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        Turtle turtle = getTurtle();

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

        for (int i = 0; i < 6; i++) {
            turtle.forward(sideLength);
            turtle.turnLeft(60);
        }
    }
}
