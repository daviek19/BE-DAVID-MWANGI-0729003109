package com.cellulant.interview.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * *
 * Configures the cellulants property file under /resources folder
 *
 * @author ADMIN
 */
@Configuration
@ComponentScan(basePackages = "com.cellulant.interview")
@PropertySource(value = {"classpath:cellulant.properties"})
public class CellulantPropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
