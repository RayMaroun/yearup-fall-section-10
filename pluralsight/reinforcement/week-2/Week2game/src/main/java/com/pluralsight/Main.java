package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Character player = new Character("Hero", 35, 10);
        System.out.println("\nInitial Player Status:\n" + player.getFullStatus());

        Enemy[] enemies = new Enemy[5];
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy("Enemy " + (i + 1), (int) (Math.random() * 30 + 5));
            System.out.println(enemies[i].getName() + " has " + enemies[i].getHealth() + " health and " + enemies[i].getDamage() + " attack damage.");
        }
        System.out.println("--------------------------------------------");

        battle(player, enemies);

        System.out.println("\nBattle has ended. Player's Final Status:\n" + player.getFullStatus());
    }


    public static void battle(Character player, Enemy[] enemies) {
        for (Enemy enemy : enemies) {
            System.out.println("======================================");
            System.out.println(player.getName() + " vs " + enemy.getName());
            System.out.println("======================================");

            while (player.getHealth() > 0 && enemy.getHealth() > 0) {
                if (Math.random() > 0.5) { // 50% chance to use regular attack or attack with a multiplier
                    player.attack(enemy);
                    System.out.println(player.getName() + " attacked " + enemy.getName() + " with regular attack. " + enemy.getName() + " health is now " + enemy.getHealth());
                } else {
                    player.attack(enemy, 1.5); // Using a multiplier of 1.5 for demonstration
                    System.out.println(player.getName() + " attacked " + enemy.getName() + " with weapon multiplier. " + enemy.getName() + " health is now " + enemy.getHealth());
                }

                if (enemy.getHealth() <= 0) {
                    System.out.println(enemy.getName() + " has been defeated!");
                    break; // Exit the loop if the enemy is defeated
                }

                enemy.attack(player);
                System.out.println(enemy.getName() + " attacked " + player.getName() + ". " + player.getName() + " health is now " + player.getHealth());

                if (player.getHealth() <= 0) {
                    System.out.println(player.getName() + " has been defeated!");
                    break; // Exit the loop if the player is defeated
                }
            }
            System.out.println(); // Print a newline for separation between battles
        }
    }
}
