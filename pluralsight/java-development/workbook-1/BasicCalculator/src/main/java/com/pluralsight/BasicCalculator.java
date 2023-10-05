package com.pluralsight;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // read in the two numbers
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        // display possible calculations and ask the user for the operation
        System.out.println("\nPossible calculations:");
        System.out.println("  (A)dd");
        System.out.println("  (S)ubtract");
        System.out.println("  (M)ultiply");
        System.out.println("  (D)ivide");
        System.out.print("Please select an option: ");
        char operation = Character.toUpperCase(input.next().charAt(0)); // Take only the first character and convert to uppercase

        // perform the operation and display the result
        if (operation == 'A') {
            double result = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + result);
        } else if (operation == 'S') {
            double result = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + result);
        } else if (operation == 'M') {
            double result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);
        } else if (operation == 'D') {
            if (num2 != 0) {
                double result = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + result);
            } else {
                System.out.println("Cannot divide by zero.");
            }
        } else {
            System.out.println("Invalid operation.");
        }
    }
}
