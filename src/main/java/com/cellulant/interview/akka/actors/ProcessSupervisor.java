package com.cellulant.interview.akka.actors;

import com.cellulant.interview.common.CompanyWsdlService;
import com.cellulant.interview.common.departments.support.DepartmentService;
import com.cellulant.interview.common.employees.support.EmployeeService;
import company.wsdl.Staff;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;

@Component("ProcessSupervisor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProcessSupervisor extends AbstractLoggingActor {

    @Autowired
    private CompanyWsdlService companyWsdlService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    static public Props props() {
        return Props.create(ProcessSupervisor.class,
                () -> new ProcessSupervisor()
        );
    }

    @Override
    /**
     * The createReceive will fetch all departments and concurrently loop
     * through using the java 8 stream API to process employee and save the
     * records using jpa hibernate
     */
    public Receive createReceive() {
        return receiveBuilder().matchAny(
                any -> {
                    log().info("starting the processor...");

                    companyWsdlService.fetchDepartments().stream().forEach(x -> {
                        
                        departmentService.saveSingleDepartment(x);

                        //Get the employees
                        List<Staff> staff = companyWsdlService.fetchStaff(x.getDepartmentID());
                        staff.stream().forEach(employee -> {
                            employeeService.saveSingleEmployee(employee);;
                        });
                    });
                })
                .build();
    }

}
