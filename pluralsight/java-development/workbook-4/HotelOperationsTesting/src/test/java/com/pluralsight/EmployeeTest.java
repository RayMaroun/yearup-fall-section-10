package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void punchIn_StartTimeNotSet_StartTimeSetToGivenTime() {
        // Arrange
        Employee employee = new Employee(1, "John Doe", "IT", 20.0);

        // Act
        employee.punchIn(9.0);

        // Assert
        assertEquals(9.0, employee.getStartTime());
    }

    @Test
    public void punchOut_HoursNotSet_HoursWorkedSetCorrectly() {
        // Arrange
        Employee employee = new Employee(1, "John Doe", "IT", 20.0);
        employee.punchIn(9.0);

        // Act
        employee.punchOut(17.5);

        // Assert
        assertEquals(8.5, employee.getHoursWorked());
    }


}