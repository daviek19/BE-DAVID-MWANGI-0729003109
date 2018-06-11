package com.cellulant.interview.common;

import company.wsdl.Departments;
import company.wsdl.FetchDepartments;
import company.wsdl.FetchDepartmentsResponse;
import company.wsdl.FetchStaff;
import company.wsdl.FetchStaffResponse;
import company.wsdl.ObjectFactory;
import company.wsdl.Staff;
import java.util.List;
import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * A soap client that provides abstraction to the Cellulant Company soap API
 */
public class CompanyWsdlService extends WebServiceGatewaySupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyWsdlService.class);

    @Value("${departments_soap_action}")
    private String departmentsActionUrl;
    @Value("${departments_payload_url}")
    public String departmentsPayLoadUrl;

    private final ObjectFactory factory = new ObjectFactory();
    private final SoapActionCallback callBackUrl = new SoapActionCallback(departmentsActionUrl);

    /**
     * Fetch a list of cellulants departments
     *
     * @return
     */
    public List<Departments> fetchDepartments() {

        JAXBElement<FetchDepartmentsResponse> response;
        List<Departments> departments = null;
        FetchDepartments request = factory.createFetchDepartments();

        try {
            response
                    = (JAXBElement<FetchDepartmentsResponse>) getWebServiceTemplate()
                            .marshalSendAndReceive(departmentsActionUrl, request, callBackUrl);

            departments = response.getValue().getReturn();
        } catch (Exception e) {
            LOGGER.error("fetchDepartments", e);
        }

        return departments;
    }

    public List<Staff> fetchStaff(Integer departmentID) {
        JAXBElement<FetchStaffResponse> response;
        List<Staff> staffList = null;

        FetchStaff request = factory.createFetchStaff();
        request.setDepartmentID(departmentID);

        try {
            response
                    = (JAXBElement<FetchStaffResponse>) getWebServiceTemplate()
                            .marshalSendAndReceive(departmentsActionUrl, request, callBackUrl);

            staffList = response.getValue().getReturn();
        } catch (Exception e) {
            LOGGER.error("fetchStaff", e);
        }
        return staffList;
    }
}
