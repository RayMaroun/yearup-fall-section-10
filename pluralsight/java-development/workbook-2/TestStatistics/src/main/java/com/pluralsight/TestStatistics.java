package com.pluralsight;

import java.util.Arrays;

public class TestStatistics {
    public static void main(String[] args) {
        // Create an array of 10 test scores
        int[] scores = {87, 91, 65, 98, 75, 82, 90, 79, 88, 94};

        // Initialize variables to calculate average, high score, and low score
        int sum = 0;
        int highScore = scores[0];
        int lowScore = scores[0];

        // Loop through each score in the array
        for (int i = 0; i < scores.length; i++) {
            // Calculate the sum of all scores
            sum += scores[i];
            // Check if the current score is higher than the previous high score
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
            // Check if the current score is lower than the previous low score
            if (scores[i] < lowScore) {
                lowScore = scores[i];
            }
        }

        // Calculate the average score by dividing the sum by the number of scores
        double average = (double) sum / scores.length;

        // Print out the average, high score, and low score
        System.out.printf("Average: %.2f\n", average);
        System.out.println("High score: " + highScore);
        System.out.println("Low score: " + lowScore);

        // Calculate and print the median value
        Arrays.sort(scores);
        double median;
        if (scores.length % 2 == 0) {
            // If the array has an even number of elements, average the middle two
            int middle1 = scores.length / 2 - 1;
            int middle2 = scores.length / 2;
            median = (scores[middle1] + scores[middle2]) / 2.0;
        } else {
            // If the array has an odd number of elements, take the middle one
            int middle = scores.length / 2;
            median = scores[middle];
        }
        System.out.println("Median: " + median);
    }
}
