package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_RoomInitialStatus_RoomIsOccupiedAndDirty() {
        // Arrange
        Room room = new Room(2, 100.0);

        // Act
        room.checkIn();

        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkout_RoomIsOccupied_RoomIsNotOccupied() {
        // Arrange
        Room room = new Room(1, 50.0);
        room.checkIn();

        // Act
        room.checkout();

        // Assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void checkIn_RoomWasPreviouslyUsed_RoomIsNotOccupied() {
        // Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();
        room.checkout();

        // Act
        room.checkIn();

        // Assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void cleanRoom_RoomIsOccupied_RoomRemainsDirty() {
        // Arrange
        Room room = new Room(2, 100.0);
        room.checkIn();

        // Act
        room.cleanRoom();

        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_RoomWasPreviouslyUsed_RoomIsNotDirty() {
        // Arrange
        Room room = new Room(1, 50.0);
        room.checkIn();
        room.checkout();

        // Act
        room.cleanRoom();

        // Assert
        assertFalse(room.isDirty());
    }


}