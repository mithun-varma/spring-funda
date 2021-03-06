/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.jpa.entities.Course;
import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.Person;
import com.funda.backend.jpa.entities.Student;
import com.funda.backend.jpa.repositories.EmployeeRepository;
import com.funda.backend.jpa.repositories.PersonJpaRepository;
import com.funda.backend.jpa.repositories.StudentRepository;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DBInitilizer implements CommandLineRunner {
    private EmployeeRepository empRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @PersistenceContext
    EntityManager em;
    
    private final String SAMPLE_DATA = "classpath:testdata.sql";

    @Autowired
    private ResourceLoader resourceLoader;
    
    @Autowired
    private DataSource datasource;
//    @Autowired
//    PersonJDBCRepository personDao;
    
    @Autowired
    PersonJpaRepository personRepo;
    
    public DBInitilizer(EmployeeRepository empRepository){
        this.empRepository = empRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
        this.empRepository.deleteAll();
        Employee emp1 = new Employee("mith","HII","1000");
        Employee emp2 = new Employee("Anna","HII","3000");
        Employee emp3 = new Employee("Nag","HII","3000");
        Employee emp4 = new Employee("Sri","HII","3000");
        Employee emp5 = new Employee("siri","HII","3000");

        this.empRepository.save(emp1);
        this.empRepository.save(emp2);
        this.empRepository.save(emp3);
        this.empRepository.save(emp4);
        this.empRepository.save(emp5);   
        //JDBC 
        //System.out.println("all users "+personDao.findAll());
        
        
        //JPA
        System.out.println(" userid from jpa "+personRepo.findById(10L));
        System.out.println("Inserting -> {}");
        personRepo.insert(new Person("Tara", "Berlin", new Date()));
        System.out.println("Update 2 -> {}"+
        personRepo.update(new Person(2L, "Pieter", "Utrecht", new Date())));
        studentRepository.insertStudentAndCourse();
//        Resource resource = resourceLoader.getResource(SAMPLE_DATA);
//        ScriptUtils.executeSqlScript(datasource.getConnection(), resource);
        System.out.println(" -- Database has been initialized thats");
    }
}
 
