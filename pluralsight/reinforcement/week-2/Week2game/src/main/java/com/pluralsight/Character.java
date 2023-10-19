package com.pluralsight;

public class Character {
    private String name;
    private int health;
    private int strength;
    private int agility;

    public Character(String name, int strength, int agility) {
        this.name = name;
        this.health = 100;
        this.strength = strength;
        this.agility = agility;
    }

    public Character(String name) {
        this(name, 30, 10);  // Default values
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    // Setter for health with a check to ensure it doesn't go below 0
    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    // Inside the Character class
    public String getDescription() {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public String getHealthStatus() {
        return health + " HP";
    }

    // Inside the Character class
    public String getFullStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getDescription()).append("\n");
        sb.append("Health: ").append(getHealthStatus()).append("\n");
        sb.append("Strength: ").append(strength).append("\n");
        sb.append("Agility: ").append(agility);
        return sb.toString();
    }

    public void attack(Enemy enemy) {
        int damageDone = this.strength;
        enemy.setHealth(enemy.getHealth() - damageDone);
        System.out.println("You dealt " + damageDone + " damage to " + enemy.getName() + "!");
    }

    public void attack(Enemy enemy, double weaponMultiplier) {
        int damageDone = (int)(this.strength * weaponMultiplier);
        enemy.setHealth(enemy.getHealth() - damageDone);
        System.out.println("With the weapon multiplier, you dealt " + damageDone + " damage to " + enemy.getName() + "!");
    }
}
