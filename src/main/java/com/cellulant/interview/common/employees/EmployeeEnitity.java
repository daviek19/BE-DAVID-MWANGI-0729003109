package com.cellulant.interview.common.employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * *
 * annotated as a JPA entity. This will form the mysql schema for employee
 *
 */
@Entity
public class EmployeeEnitity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeEnitityId;
    private String dateCreated;
    private String dateModified;
    private int departmentID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private Integer staffID;

    public Long getEmployeeEnitityId() {
        return employeeEnitityId;
    }

    public void setEmployeeEnitityId(Long employeeEnitityId) {
        this.employeeEnitityId = employeeEnitityId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

}
