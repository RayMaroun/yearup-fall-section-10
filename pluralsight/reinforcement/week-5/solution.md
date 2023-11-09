## Step 1 - Creating the Guest Class

**Solution:**

The `Guest` class will contain the necessary information for a guest, such as name, age, and a flag to check if they are checked into a room.

```java
public class Guest {
    private String name;
    private int age;
    private boolean isCheckedIn;

    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCheckedIn = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Check-in and Check-out methods
    public void checkIn() {
        this.isCheckedIn = true;
    }

    public void checkOut() {
        this.isCheckedIn = false;
    }
}
```

## Step 2 - Creating the Room Class

**Solution:**

The `Room` class will manage the room details, including room number, type, and occupancy status.

```java
public class Room {
    private int roomNumber;
    private String roomType;
    private boolean isOccupied;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = false;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // Room booking methods
    public boolean bookRoom() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    public void vacateRoom() {
        isOccupied = false;
    }
}
```

## Step 3 - Managing Room Bookings with Overloading

**Solution:**

We'll add overloads for the `bookRoom` and `vacateRoom` methods to handle the guest's check-in status.

```java
// Within the Room class

public boolean bookRoom(Guest guest) {
    if (!isOccupied) {
        isOccupied = true;
        guest.checkIn();
        return true;
    }
    return false;
}

public void vacateRoom(Guest guest) {
    isOccupied = false;
    guest.checkOut();
}
```

## Step 4 - Creating the Staff Class

**Solution:**

The `Staff` class will hold details about hotel staff, including their name, position, and identification number.

```java
public class Staff {
    private String name;
    private String position;
    private int id;

    public Staff(String name, String position, int id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String performDuty(String dutyDescription) {
        return name + " is performing duty: " + dutyDescription;
    }
}
```

## Step 5 - Adding Static Features to Track Bookings

**Solution:**

We introduce a static counter within the `Hotel` class to track the total number of bookings.

```java
public class Hotel {
    private static int totalBookings = 0;

    public static int getTotalBookings() {
        return totalBookings;
    }

    public static void increaseTotalBookings() {
        totalBookings++;
    }

    public static void decreaseTotalBookings() {
        totalBookings--;
    }
}
```

Update `bookRoom` and `vacateRoom` methods accordingly.

```java
public boolean bookRoom() {
    if (!isOccupied) {
        isOccupied = true;
        Hotel.increaseTotalBookings();
        return true;
    }
    return false;
}

public void vacateRoom() {
    isOccupied = false;
    Hotel.decreaseTotalBookings();
}

public boolean bookRoom(Guest guest) {
    if (!isOccupied) {
        isOccupied = true;
        guest.checkIn();
        Hotel.increaseTotalBookings();
        return true;
    }
    return false;
}

public void vacateRoom(Guest guest) {
    isOccupied = false;
    guest.checkOut();
    Hotel.decreaseTotalBookings();
}
```

## Step 6 - Writing Unit Tests

**Solution:**

For this step, we are writing and running unit tests for our hotel management system to ensure that room booking, guest check-in/out processes, and overall booking tracking are functioning correctly.

```java
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
```

```java
package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    public void checkIn_GuestChecksIn_IsCheckedInTrue() {
        // Arrange
        Guest guest = new Guest("Alice Johnson", 25);

        // Act
        guest.checkIn();

        // Assert
        assertTrue(guest.isCheckedIn(), "Guest should be checked in after check-in operation");
    }

    @Test
    public void checkOut_GuestChecksOut_IsCheckedInFalse() {
        // Arrange
        Guest guest = new Guest("Alice Johnson", 25);
        guest.checkIn(); // Guest is checked in before checking out

        // Act
        guest.checkOut();

        // Assert
        assertFalse(guest.isCheckedIn(), "Guest should not be checked in after check-out operation");
    }

}
```

```java
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
```

## Step 7 - Simulating Hotel Operations

**Solution:**

This code creates several `Room`, `Guest`, and `Staff` objects. It then simulates room bookings, checking guests in and out, and staff performing duties. After each operation, it outputs the current status using `System.out.println`. This simulation is simplistic and assumes operations are performed in sequence without error checking or exception handling, which would be necessary in a real-world application.

```java
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
```
