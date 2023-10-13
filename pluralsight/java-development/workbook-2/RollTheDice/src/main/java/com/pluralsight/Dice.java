package com.pluralsight;

// Define the Dice class.
public class Dice {

    // Define the constructor for the Dice class.
    public Dice() {
    }

    // Define the roll method for the Dice class.
    public int roll() {
        // Generate a random integer between 0 and 5 and add 1 to get a value between 1 and 6, then return it.
        return (int) (Math.random() * 6) + 1;
    }
}
