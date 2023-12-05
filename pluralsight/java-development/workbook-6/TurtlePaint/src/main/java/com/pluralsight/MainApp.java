package com.pluralsight;

import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;

import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        // Define a radius for the circle to be drawn
        double radius = 100;
        // Calculate the circumference of the circle using the radius
        double circumference = 2 * Math.PI * radius;
        // Calculate the length of each line segment to draw the circle
        double lineLength = circumference / 360;

        // Print the radius, circumference, and line length to the console
        System.out.println(radius);
        System.out.println(circumference);
        System.out.println(lineLength);

        // Create a new 'world' (drawing area) with specified dimensions
        World world = new World(500, 500);
        // Create a new 'turtle' (drawing tool) at the origin (0, 0) of the world
        Turtle t = new Turtle(world, 0, 0);

        // Set various drawing properties of the turtle
        t.setPenWidth(4);
        t.setColor(Color.RED);
        t.setDelay(0.00);

        // Make the drawing world visible
        world.setVisible(true);

        // Uncomment to draw different shapes
        // drawGrid(t);
        //drawFullCircle(t); // Draw a full circle using the turtle
        // drawPie(t);
        // drawSquare(t);

        // Save the drawing as an image file
        world.saveAs("circle.png");

        // Uncomment to dispose of the drawing world when done
        // world.dispose();
    }

    // A method to draw a square using the Turtle
    private static void drawSquare(Turtle t) {
        t.penUp(); // Lift the pen to move without drawing
        t.goTo(-100, -100); // Move the turtle to the starting point
        t.setHeading(0); // Set the turtle's direction to right

        t.penDown(); // Put the pen down to start drawing
        // Draw a square by repeating forward movement and left turns
        for (int i = 0; i < 4; i++) {
            t.forward(200); // Move forward 200 units
            t.turnLeft(90); // Turn left by 90 degrees
        }
    }

    // A method to draw a grid using the Turtle
    public static void drawGrid(Turtle t) {
        t.penUp(); // Lift the pen up
        t.goTo(-250, 0); // Move to start position for horizontal line
        t.setHeading(0); // Face right
        t.setColor(Color.BLACK); // Set pen color to black
        t.setPenWidth(6); // Set pen width

        t.penDown(); // Start drawing
        t.forward(500); // Draw horizontal line
        t.penUp(); // Lift pen

        // Move to start position for vertical line
        t.goTo(0, 250);
        t.penDown(); // Start drawing
        t.setHeading(90); // Face upwards
        t.forward(500); // Draw vertical line
        t.penUp(); // Lift pen

        // Draw additional grid lines
        t.setPenWidth(.5); // Set thinner pen width
        t.setHeading(90); // Face upwards
        // Draw vertical grid lines
        for (int i = -250; i <= 500; i += 25) {
            t.penUp();
            t.goTo(i, 250);
            t.penDown();
            t.forward(500);
        }

        // Draw horizontal grid lines
        t.setHeading(0); // Face right
        for (int i = 250; i >= -250; i -= 25) {
            t.penUp();
            t.goTo(-250, i);
            t.penDown();
            t.forward(500);
        }
        t.penUp(); // Lift pen after drawing
    }

    // A method to draw a full circle using the Turtle
    public static void drawFullCircle(Turtle t) {
        t.penUp(); // Lift the pen
        t.goTo(0, 0); // Move to center of the circle
        double radius = 100; // Define the radius
        double circumference = 2 * Math.PI * radius; // Calculate circumference
        double lineLength = circumference / 360; // Length of each small line segment

        t.setPenWidth(3); // Set pen width
        t.setColor(Color.RED); // Set pen color

        // Move to the start position of the circle
        t.penUp();
        t.turnRight(90);
        t.forward(radius);
        t.turnLeft(90);
        t.penDown();

        // Draw the circle by rotating and moving in small segments
        for (int degrees = 360; degrees > 0; degrees--) {
            t.forward(lineLength); // Move forward a small segment
            t.turnLeft(1); // Turn slightly
        }
    }

    // A method to draw a pie shape using the Turtle
    public static void drawPie(Turtle t) {
        double radius = 100; // Define the radius
        double circumference = 2 * Math.PI * radius; // Calculate circumference
        double lineLength = circumference / 360; // Length of each small line segment

        // Drawing the first quarter arc
        t.forward(radius); // Move to the rim of the pie
        t.turnLeft(90); // Orient for arc drawing

        // Draw the arc
        for (int degrees = 270; degrees > 0; degrees--) {
            t.forward(lineLength); // Move forward a small segment
            t.turnLeft(1); // Turn slightly
        }
        t.turnLeft(90); // Reorient
        t.forward(radius); // Move back to center

        // Position for the next quarter arc
        t.penUp(); // Lift pen
        t.turnRight(90); // Turn
        t.forward(10); // Move slightly
        t.turnRight(90); // Turn
        t.forward(10); // Move slightly

        // Draw the second quarter arc
        t.setColor(Color.BLUE); // Change color
        t.penDown(); // Start drawing
        t.forward(radius); // Move to the rim
        t.turnLeft(90); // Orient for arc drawing

        // Draw the arc
        for (int degrees = 90; degrees > 0; degrees--) {
            t.forward(lineLength); // Move forward a small segment
            t.turnLeft(1); // Turn slightly
        }
        t.turnLeft(90); // Reorient
        t.forward(radius); // Move back to center
    }
}
