package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void bookRoom_RoomAlreadyOccupied_ExpectFalse() {
        // Arrange
        Room room = new Room(101, "Single");
        Guest guest1 = new Guest("Alice Johnson", 25);
        room.bookRoom(guest1); // First booking
        Guest guest2 = new Guest("Bob Smith", 30);

        // Act
        boolean result = room.bookRoom(guest2); // Attempt to book again

        // Assert
        assertFalse(result, "Room should not be bookable if already occupied");
    }
}