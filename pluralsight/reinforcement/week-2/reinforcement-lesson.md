# Week 2 Reinforcement Live Coding Session - Developing a Text-Based Game

## Introduction

In this session, we'll combine the skills learned during week 2 to create a text-based game. This game will involve string manipulation, user-defined classes, methods, and the use of loops and arrays. The game will be a character creation and simple combat game where players can create a character, assign attributes, and face off against enemies.

## Step 1 - Creating the Character Class

**Instructions:**

1. Create a new class named `Character`.
2. Declare private attributes for `name`, `health`, `strength`, and `agility`.
3. Set the health to a default value of 100 in the constructors.
4. Provide two constructors: one accepting `name`, `strength`, and `agility` and another accepting just the `name` with default values for `strength` and `agility`.
5. Implement getters and setters for each attribute. Ensure the `setHealth` method does not allow for negative health values.

---

## Step 2 - String Manipulation and Conversion

**Instructions:**

1. In the `Character` class, write a method named `getDescription` that returns the character's name with the first letter capitalized and the rest in lowercase.
2. Create a method named `getHealthStatus` that returns the character's current health followed by " HP".

---

## Step 3 - Using StringBuilder

**Instructions:**

1. Develop a method within the `Character` class named `getFullStatus`.
2. Use the `StringBuilder` class to concatenate the character's name, health status, strength, and agility.
3. This method should return a formatted string with the character's full status.

---

## Step 4 - Creating the Enemy Class

**Instructions:**

1. Create a new class named `Enemy`.
2. Define private attributes for `name`, `health`, and `damage`.
3. Set the health to a default value of 100 in the constructors.
4. Provide two constructors: one accepting `name` and `damage` and another accepting just the `name` with a default value for `damage`.
5. Implement getters and setters for each attribute. Ensure the `setHealth` method does not allow for negative health values.

---

## Step 5 - Overloading Methods

**Instructions:**

1. Navigate to the `Character` class.
2. Implement a method named `attack` that accepts an `Enemy` object as a parameter. This method should decrease the enemy's health based on the character's strength.
3. Create an overloaded `attack` method that also accepts a `weaponMultiplier` to modify the damage dealt.
4. In the `Enemy` class, implement a method named `attack` that accepts a `Character` object. This method should decrease the character's health based on the enemy's damage.
5. Overload the `attack` method in the `Enemy` class to also accept a `specialAbilityMultiplier`.

---

## Step 6 - Working with Loops

**Instructions:**

1. In your main class, develop a method named `battle` that simulates a combat sequence between a character and an array of enemies.
2. Inside the `battle` method, use loops to continue the battle until the character's health reaches zero or all enemies are defeated.
3. For each attack, print out the result, showing how much damage was dealt and the remaining health of the character and enemy.

---

## Step 7 - Working with Arrays

**Instructions:**

1. In your main class, define an array to store multiple `Enemy` objects.
2. Use a loop to initialize each `Enemy` object in the array with a unique name and a randomly generated damage value between 5 and 15.
3. Display the initial health and damage of each enemy before starting the battle.

---

## Step 8 - Testing

**Instructions:**

1. In your main method, create an instance of the `Character` class.
2. Print the initial status of the character using the `getFullStatus` method.
3. Create an array of `Enemy` objects and initialize them as explained in Step 7.
4. Initiate the battle between the character and the array of enemies using the `battle` method.
5. After the battle concludes, print the final status of the character.
6. Run the program to observe the combat simulation and ensure everything works as expected.
