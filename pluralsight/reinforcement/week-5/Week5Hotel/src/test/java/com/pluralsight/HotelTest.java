package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    public void getTotalBookings_ThreeBookings_ExpectTotalBookingsThree() {
        // Arrange
        Room room1 = new Room(102, "Double");
        Room room2 = new Room(103, "Suite");
        Room room3 = new Room(104, "Single");
        room1.bookRoom(new Guest("Alice Johnson", 25));
        room2.bookRoom(new Guest("Bob Smith", 30));
        room3.bookRoom(new Guest("Charlie Garcia", 35));

        // Act
        int actualTotalBookings = Hotel.getTotalBookings();

        // Assert
        assertEquals(3, actualTotalBookings, "Total bookings should match the number of rooms booked");
    }
}