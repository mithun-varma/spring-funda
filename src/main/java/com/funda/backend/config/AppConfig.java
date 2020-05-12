/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.servlets.SampleServlet;
import com.funda.backend.vo.Employee;
import java.sql.SQLException;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author phanic
 */
@Configuration
@ConfigurationProperties(prefix = "conversion")
public class AppConfig {

    private Employee employee;

    @PostConstruct
    public void loadDB() throws SQLException {
        String name = employee != null ? employee.getName() : "testing may be ";
        System.out.println("the employee is " + name);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource
//                = new ReloadableResourceBundleMessageSource();
//
//        messageSource.setBasename("classpath:message");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean getValidator() {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }
    
    @Bean
    ServletRegistrationBean myServletRegistration () {
      ServletRegistrationBean srb = new ServletRegistrationBean();
      srb.setServlet(new SampleServlet());
      srb.setUrlMappings(Arrays.asList("/ss/*"));
      return srb;
    }

}
