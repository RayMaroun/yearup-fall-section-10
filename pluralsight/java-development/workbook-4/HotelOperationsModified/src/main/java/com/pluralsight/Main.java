package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Create a new room with two beds and a price of $100 per night
        Room room = new Room(2, 100.00);

        // Check in a guest and mark the room as dirty
        room.checkIn();
        System.out.println("Room is occupied: " + room.isOccupied());
        System.out.println("Room is dirty: " + room.isDirty());

        // Guest checks out and room is cleaned
        room.checkout();
        System.out.println("Room is occupied: " + room.isOccupied());
        room.cleanRoom();
        System.out.println("Room is dirty: " + room.isDirty());

        // Create a new employee and punch in
        Employee employee = new Employee(1, "John Doe", "Housekeeping", 15.00);
        employee.punchIn(9.0);

        // Employee works for 8.5 hours and punches out
        employee.punchOut(17.5);
        System.out.println("Hours worked: " + employee.getHoursWorked());
        System.out.println("Total pay: " + employee.getTotalPay());
        System.out.println("Regular hours: " + employee.getRegularHours());
        System.out.println("Overtime hours: " + employee.getOvertimeHours());

        // Employee punches time card again
        employee.punchTimeCard(9.0);
        employee.punchTimeCard(18.0);
        System.out.println("Hours worked: " + employee.getHoursWorked());
        System.out.println("Total pay: " + employee.getTotalPay());
        System.out.println("Regular hours: " + employee.getRegularHours());
        System.out.println("Overtime hours: " + employee.getOvertimeHours());
    }
}
