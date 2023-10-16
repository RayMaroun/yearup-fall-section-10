package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class QuotesApp {
    public static void main(String[] args) {
        String[] quotes = {
                "All that glitters is not gold",
                "A stitch in time saves nine",
                "Actions speak louder than words",
                "Honesty is the best policy",
                "You can't have your cake and eat it too",
                "The early bird catches the worm",
                "An apple a day keeps the doctor away",
                "There's no place like home",
                "When in Rome, do as the Romans do",
                "You reap what you sow"
        };

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        Random random = new Random();

        while (continueLoop) {
            try {
                System.out.println("1. Enter a number between 1-10 to display a specific quote.");
                System.out.println("2. Enter 'R' to display a random quote.");
                System.out.print("Your choice: ");

                String input = scanner.next();

                if (input.equalsIgnoreCase("R")) {
                    int randomIndex = random.nextInt(quotes.length);
                    System.out.println(quotes[randomIndex]);
                } else {
                    int index = Integer.parseInt(input);
                    System.out.println(quotes[index - 1]);
                }

                System.out.print("Do you want to see another quote? (Y/N): ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("N")) {
                    continueLoop = false;
                }
            } catch (Exception exception) {
                System.out.println("Invalid input. Please enter a number between 1 and 10 or 'R' for a random quote.");
                scanner.nextLine();  // Clear the buffer.
            }
        }

        scanner.close();
    }
}
