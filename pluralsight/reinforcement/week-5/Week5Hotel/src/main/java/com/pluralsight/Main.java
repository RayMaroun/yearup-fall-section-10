package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Step 7.1 - Instantiating Rooms, Guests, and Staff
        Room room101 = new Room(101, "Single");
        Room room102 = new Room(102, "Double");
        Room room103 = new Room(103, "Suite");

        Guest guest1 = new Guest("Alice Johnson", 25);
        Guest guest2 = new Guest("Bob Smith", 30);
        Guest guest3 = new Guest("Charlie Garcia", 35);

        Staff staff1 = new Staff("Diana Prince", "Receptionist", 1);
        Staff staff2 = new Staff("Bruce Wayne", "Housekeeping", 2);

        // Step 7.2 - Simulating Operations
        // Booking rooms
        boolean booking1 = room101.bookRoom(guest1);
        System.out.println("Room 101 booking status for Alice: " + booking1);

        System.out.println("Current Total Bookings: " + Hotel.getTotalBookings());


        boolean booking2 = room102.bookRoom(guest2);
        System.out.println("Room 102 booking status for Bob: " + booking2);

        System.out.println("Current Total Bookings: " + Hotel.getTotalBookings());

        // Trying to book an occupied room
        boolean booking3 = room101.bookRoom(guest3);
        System.out.println("Room 101 booking status for Charlie: " + booking3);

        System.out.println("Current Total Bookings: " + Hotel.getTotalBookings());

        // Step 7.3 - Outputting the Status
        // Check the occupancy status of each room
        System.out.println("Room 101 is occupied: " + room101.isOccupied());
        System.out.println("Room 102 is occupied: " + room102.isOccupied());
        System.out.println("Room 103 is occupied: " + room103.isOccupied());

        // Check if guests are checked in
        System.out.println("Alice is checked in: " + guest1.isCheckedIn());
        System.out.println("Bob is checked in: " + guest2.isCheckedIn());
        System.out.println("Charlie is checked in: " + guest3.isCheckedIn());

        // Staff performing duties
        String duty1 = staff1.performDuty("Check-in guest Alice");
        System.out.println(duty1);

        String duty2 = staff2.performDuty("Clean room 102");
        System.out.println(duty2);

        // Checking out a guest
        room101.vacateRoom(guest1);
        System.out.println("Room 101 is occupied after Alice checks out: " + room101.isOccupied());
        System.out.println("Alice is checked in after checking out: " + guest1.isCheckedIn());

        System.out.println("Current Total Bookings: " + Hotel.getTotalBookings());
    }
}
