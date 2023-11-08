# Week 5 Reinforcement Lab - Hotel Management System

## Introduction

In this session, we will develop a basic hotel management system focusing on encapsulation, method overloading, unit testing with JUnit, and static members. This system will handle guests, staff, and room operations.

## Step 1 - Creating the Guest Class

**Instructions:**

1. Define a `Guest` class with private attributes: `String name`, `int age`, and `boolean isCheckedIn`.
2. Include a constructor that accepts `name` and `age` and sets `isCheckedIn` to `false`.
3. Write encapsulated `getter` and `setter` methods for each attribute.
4. Add a method `checkIn` that sets `isCheckedIn` to `true`.
5. Add a method `checkOut` that sets `isCheckedIn` to `false`.

---

## Step 2 - Creating the Room Class

**Instructions:**

1. Define a `Room` class with private attributes: `int roomNumber`, `String roomType`, and `boolean isOccupied`.
2. Write a constructor to set `roomNumber` and `roomType`. Initialize `isOccupied` as `false`.
3. Provide `getter` methods for each attribute.
4. Implement a method `bookRoom` that sets `isOccupied` to `true` if it is not already occupied, and returns a boolean indicating success.
5. Create a method `vacateRoom` to set `isOccupied` to `false`.

---

## Step 3 - Managing Room Bookings with Overloading

**Instructions:**

1. Overload the `bookRoom` method to accept a `Guest` object as a parameter. If booking is successful, set the `Guest`'s `isCheckedIn` status to `true`.
2. Overload the `vacateRoom` method similarly to update the `Guest`'s status.

---

## Step 4 - Creating the Staff Class

**Instructions:**

1. Define a `Staff` class with private attributes: `String name`, `String position`, and `int id`.
2. Create a constructor that initializes these attributes.
3. Implement `getter` and `setter` methods for each attribute.
4. Add a method `performDuty` that takes a `String dutyDescription` and returns a `String` indicating the duty performed.

---

## Step 5 - Adding Static Features to Track Bookings

**Instructions:**

1. Inside the `Hotel` class, declare a private static `int` variable `totalBookings`.
2. Create a public static method `getTotalBookings` that returns the value of `totalBookings`.
3. Create a public static method `increaseTotalBookings` that increases the value of `totalBookings`.
4. Create a public static method `decreaseTotalBookings` that decreases the value of `totalBookings`.
5. Modify the `bookRoom` method to increment `totalBookings` whenever a room is successfully booked.
6. Modify the `vacateRoom` method to decrement `totalBookings` whenever a room is successfully vacated.

---

## Step 6 - Writing Unit Tests

**Instructions:**

1. Create new test classes as needed.
2. Write tests to ensure that a room cannot be booked if it is already occupied.
3. Write tests to check a guest in and out and verify the `isCheckedIn` status changes appropriately.
4. Test the static method `getTotalBookings` to ensure it accurately tracks the number of bookings.

---

## Step 7 - Simulating Hotel Operations

**Instructions:**

1. In your `Main` class, instantiate several `Room` and `Guest` objects, and a few `Staff` members.
2. Simulate operations such as booking rooms, checking guests in and out, and staff performing duties.
3. Use `System.out.println` to output the status of room occupancy, guest check-ins, and duties performed after each operation.
