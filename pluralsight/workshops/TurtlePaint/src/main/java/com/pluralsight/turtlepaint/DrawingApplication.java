package com.pluralsight.turtlepaint;

import java.util.Scanner;

public class DrawingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the world canvas: ");
        int canvasSize = scanner.nextInt();

        World world = new World(canvasSize, canvasSize);

        boolean exit = false;
        int choice;
        while (!exit) {
            System.out.println("\nHome Screen");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addShape(world, scanner);
                    break;
                case 2:
                    saveImage(world, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    closeWorld(world);
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void addShape(World world, Scanner scanner) {
        System.out.println("\nWhich shape would you like to add?");
        System.out.println("1. Square");
        System.out.println("2. Circle");
        System.out.println("3. Triangle");
        System.out.println("4. Hexagon");
        System.out.print("Enter your choice: ");
        int shapeChoice = scanner.nextInt();

        System.out.print("Enter the x-coordinate of the shape's location: ");
        int x = scanner.nextInt();
        System.out.print("Enter the y-coordinate of the shape's location: ");
        int y = scanner.nextInt();
        Point location = new Point(x, y);

        Turtle turtle = new Turtle(world, location.getX(), location.getY());

        System.out.print("Enter the border width: ");
        int border = scanner.nextInt();
        System.out.print("Enter the border color: ");
        String color = scanner.next();

        Shape shape;
        switch (shapeChoice) {
            case 1:
                System.out.print("Enter the side length of the square: ");
                int sideLength = scanner.nextInt();
                shape = new Square(turtle, location, color, border, sideLength);
                break;
            case 2:
                System.out.print("Enter the radius of the circle: ");
                int radius = scanner.nextInt();
                shape = new Circle(turtle, location, color, border, radius);
                break;
            case 3:
                System.out.print("Enter the side length of the triangle: ");
                int triangleSideLength = scanner.nextInt();
                shape = new Triangle(turtle, location, color, border, triangleSideLength);
                break;
            case 4:
                System.out.print("Enter the side length of the hexagon: ");
                int hexagonSideLength = scanner.nextInt();
                shape = new Hexagon(turtle, location, color, border, hexagonSideLength);
                break;
            default:
                System.out.println("Invalid choice. Shape not added.");
                return;
        }

        shape.paint();
    }

    public static void saveImage(World world, Scanner scanner) {
        System.out.print("Enter the filename to save the image: ");
        String filename = scanner.next();
        world.saveAs(filename);
        System.out.println("Image saved successfully!");
    }

    public static void closeWorld(World world) {
        world.dispose(); // This will close the JFrame
    }
}
