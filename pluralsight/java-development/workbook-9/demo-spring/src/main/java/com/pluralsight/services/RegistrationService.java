package com.pluralsight.services;

import com.pluralsight.dao.interfaces.IRegistrationDAO;
import com.pluralsight.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    private final IRegistrationDAO registrationDAO;

    @Autowired
    public RegistrationService(IRegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    public Long registerStudent(Student student) throws StudentAlreadyRegisteredException {
        if (this.registrationDAO.findById(student.getId()) != null) {
            throw new StudentAlreadyRegisteredException();
        }
        return registrationDAO.persistStudent(student);
    }
}
