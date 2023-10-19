package com.pluralsight;

public class Enemy {
    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.health = 100;
        this.damage = damage;
    }

    public Enemy(String name) {
        this(name, 30);  // Default values
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(Character character) {
        int damageDone = this.damage;
        character.setHealth(character.getHealth() - damageDone);
        System.out.println("Enemy " + this.getName() + " dealt " + damageDone + " damage to you!");
    }

    public void attack(Character character, double specialAbilityMultiplier) {
        int damageDone = (int)(this.damage * specialAbilityMultiplier);
        character.setHealth(character.getHealth() - damageDone);
        System.out.println("With a special ability, enemy " + this.getName() + " dealt " + damageDone + " damage to you!");
    }
}
