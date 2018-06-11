package com.cellulant.interview.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * This class is a soap client for cellulant's wsdl web service
 *
 * @author ADMIN
 */
@Configuration
public class CompanySoapClientConfig {

    @Value("${cullant_wsdl_endpoint_url}")
    public String cellulentWsdlEndPoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("company.wsdl");
        return marshaller;
    }

    @Bean
    public CompanyWsdlService CcompanyWsdlService(Jaxb2Marshaller marshaller) {
        CompanyWsdlService client = new CompanyWsdlService();
        client.setDefaultUri(cellulentWsdlEndPoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
