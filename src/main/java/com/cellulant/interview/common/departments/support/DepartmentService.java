package com.cellulant.interview.common.departments.support;

import com.cellulant.interview.common.departments.DepartmentEntity;
import com.cellulant.interview.common.departments.DepartmentRepository;
import company.wsdl.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class handle all service related with persisting data to the database
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveSingleDepartment(Departments departments) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDateCreated(departments.getDateCreated());
        departmentEntity.setDateModified(departments.getDateModified());
        departmentEntity.setDepartmentID(departments.getDepartmentID());
        departmentEntity.setDescription(departments.getDescription());
        departmentEntity.setName(departments.getName());
        departmentRepository.save(departmentEntity);
    }

}
