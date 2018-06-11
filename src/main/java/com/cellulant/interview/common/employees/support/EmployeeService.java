package com.cellulant.interview.common.employees.support;

import com.cellulant.interview.common.employees.EmployeeEnitity;
import com.cellulant.interview.common.employees.EmployeeRepository;
import company.wsdl.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class handle all service related with persisting employee data to the database
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveSingleEmployee(Staff staff) {
        EmployeeEnitity employeeEnitity = new EmployeeEnitity();
        employeeEnitity.setDateCreated(staff.getDateCreated());
        employeeEnitity.setDateModified(staff.getDateModified());
        employeeEnitity.setDepartmentID(staff.getDepartmentID());
        employeeEnitity.setEmailAddress(staff.getEmailAddress());
        employeeEnitity.setFirstName(staff.getFirstName());
        employeeEnitity.setLastName(staff.getLastName());
        employeeEnitity.setStaffID(staff.getStaffID());
        employeeRepository.save(employeeEnitity);
    }
}
