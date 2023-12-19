package com.pluralsight.dao.interfaces;

import com.pluralsight.models.Student;

public interface IRegistrationDAO {
    Long persistStudent(Student student);

    Student findById(Long id);
}
