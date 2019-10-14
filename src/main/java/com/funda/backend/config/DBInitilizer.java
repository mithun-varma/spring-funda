/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.hibernate.entities.Employee;
import com.funda.backend.hibernate.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DBInitilizer implements CommandLineRunner {
    private EmployeeRepository empRepository;
    
    public DBInitilizer(EmployeeRepository empRepository){
        this.empRepository = empRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
        this.empRepository.deleteAll();
        Employee emp1 = new Employee("mith","HII","1000");
        Employee emp2 = new Employee("Anna","HII","3000");
        this.empRepository.save(emp1);
        this.empRepository.save(emp2);
        System.out.println(" -- Database has been initialized");
    }
}
