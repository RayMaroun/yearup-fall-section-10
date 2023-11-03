package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter player 2 name: ");
        String player2Name = scanner.nextLine();

        Deck deck = new Deck();
        deck.shuffle();

        Hand player1Hand = new Hand();
        player1Hand.Deal(deck.deal());
        player1Hand.Deal(deck.deal());

        Hand player2Hand = new Hand();
        player2Hand.Deal(deck.deal());
        player2Hand.Deal(deck.deal());

        System.out.println(player1Name + "'s hand:");
        player1Hand.Print();

        System.out.println();

        System.out.println(player2Name + "'s hand:");
        player2Hand.Print();

        int player1Score = player1Hand.getValue();
        int player2Score = player2Hand.getValue();

        if (player1Score <= 21 && (player1Score > player2Score || player2Score > 21)) {
            System.out.println(player1Name + " wins!");
        } else if (player2Score <= 21 && (player2Score > player1Score || player1Score > 21)) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();
    }
}

