package com.pluralsight.turtlepaint;

import java.awt.*;
import java.lang.reflect.Field;

public class Triangle extends Shape {
    private int sideLength;

    public Triangle(Turtle turtle, Point location, String color, int border, int sideLength) {
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

/*        turtle.forward(sideLength);
        turtle.turnLeft(120);
        turtle.forward(sideLength);
        turtle.turnLeft(120);
        turtle.forward(sideLength);*/

        for (int i = 0; i < 3; i++) {
            turtle.forward(sideLength);
            turtle.turnLeft(120);
        }
    }
}
