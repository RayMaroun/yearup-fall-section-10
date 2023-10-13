package com.pluralsight;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        // Loop from 10 to 1
        for (int i = 10; i >= 1; i--) {
            // Print the current countdown value
            System.out.println(i);
            // Pause for one second
            Thread.sleep(1000);
        }
        // Print "Launch!" after the loop ends
        System.out.println("Launch!");
    }

/*    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            // Print the current countdown value
            System.out.println(11 - i);
            // Pause for one second
            Thread.sleep(1000);
        }
        // Print "Launch!" after the loop ends
        System.out.println("Launch!");
    }*/
}
