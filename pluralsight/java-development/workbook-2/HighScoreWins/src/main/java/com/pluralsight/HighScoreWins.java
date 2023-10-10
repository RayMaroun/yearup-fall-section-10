package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a game score
        System.out.print("Please enter a game score: ");
        String input = scanner.nextLine();

        // Find the position of the pipe character (|)
        int pipeIndex = input.indexOf('|');

        if (pipeIndex == -1) {
            System.out.println("Invalid input format.");
            scanner.close();
            return;
        }

        // Split the input into home and visitor parts
        String teamPart = input.substring(0, pipeIndex);
        String scorePart = input.substring(pipeIndex + 1);

        // Find the position of the colon character (:)
        int colonIndex = teamPart.indexOf(':');

        if (colonIndex == -1) {
            System.out.println("Invalid input format.");
            scanner.close();
            return;
        }

        // Extract team names and scores
        String homeTeam = teamPart.substring(0, colonIndex);
        String visitorTeam = teamPart.substring(colonIndex + 1);

        // Find the position of the colon character (:)
        colonIndex = scorePart.indexOf(':');

        if (colonIndex == -1) {
            System.out.println("Invalid input format.");
            scanner.close();
            return;
        }

        int homeScore = Integer.parseInt(scorePart.substring(0, colonIndex));
        int visitorScore = Integer.parseInt(scorePart.substring(colonIndex + 1));

        // Determine the winning team
        String winner;
        if (homeScore > visitorScore) {
            winner = homeTeam;
        } else if (visitorScore > homeScore) {
            winner = visitorTeam;
        } else {
            winner = "Tie"; // In case of a tie
        }

        // Display the winning team
        System.out.println("Winner: " + winner);

        scanner.close();
    }

/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a score: ");
        String input = scanner.nextLine();

        // Split the input string into team names and scores
        String[] parts = input.split("\\|");
        String homeTeam = parts[0].split(":")[0];
        String visitorTeam = parts[0].split(":")[1];
        int homeScore = Integer.parseInt(parts[1].split(":")[0]);
        int visitorScore = Integer.parseInt(parts[1].split(":")[1]);

        // Determine the winning team and display its name
        String winner = homeScore > visitorScore ? homeTeam : visitorTeam;

        System.out.println("Winner: " + winner);
    }*/
}
