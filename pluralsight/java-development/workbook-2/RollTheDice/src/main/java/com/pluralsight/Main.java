package com.pluralsight;

// Define the Main class.
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Dice class named "dice".
        Dice dice = new Dice();
        // Declare integer variables for the two dice rolls and the counters for the different sums rolled.
        int roll1, roll2;
        int twoCounter = 0, fourCounter = 0, sixCounter = 0, sevenCounter = 0;

        // Loop 20 times.
        for (int i = 0; i < 20; i++) {
            // Roll the dice twice and store the results in the roll1 and roll2 variables.
            roll1 = dice.roll();
            roll2 = dice.roll();
            // Calculate the sum of the two dice rolls.
            int sum = roll1 + roll2;
            // Print out the value of each roll of the dice, formatted in a specific way.
            System.out.printf("Roll 1: %2d - Roll 2: %2d - Sum: %2d\n", roll1, roll2, sum);
            // Use a switch statement to determine which sum was rolled and increment the appropriate counter.
            switch (sum) {
                case 2:
                    twoCounter++;
                    break;
                case 4:
                    fourCounter++;
                    break;
                case 6:
                    sixCounter++;
                    break;
                case 7:
                    sevenCounter++;
                    break;
            }
        }

        // Print out the number of times each sum was rolled.
        System.out.printf("\nNumber of times each sum was rolled:\n");
        System.out.printf(" 2: %d\n", twoCounter);
        System.out.printf(" 4: %d\n", fourCounter);
        System.out.printf(" 6: %d\n", sixCounter);
        System.out.printf(" 7: %d\n", sevenCounter);
    }
}
