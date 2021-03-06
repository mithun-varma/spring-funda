/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.tests;

import com.funda.backend.DemoApplication;
import com.funda.backend.config.MysqlDBConfig;
import com.funda.backend.jpa.entities.Book;
import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.Pen;
import com.funda.backend.jpa.repositories.EmployeeRepository;
import com.funda.backend.jpa.repositories.RoleRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author phanic
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
public class HibernateHirarchiesTest {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Autowired
    private DataSource dataSource;
    
    @Before
    public void setUp() {
    System.out.println("ready to save");    
    Employee emp = new Employee();
    emp.setId(2);
    emp.setName("mith2");
    emp.setCompany("Hii");
    employeeRepository.save(emp);
    //entityManager.persist(emp);
    }

    
    /*@Test
    public void getEmployeesCount(){
        int count = employeeRepository.findAll().size();
        System.out.println("the count is "+count);
        // then
        assertThat(count).isGreaterThan(0);
    }*/
    
    @Test
    @Transactional
    public void testSingleTableInheritance(){
        Book book = new Book();
        book.setName(" my dairies");
        book.setAuthor("phani");
        
        Pen pen = new Pen();
        pen.setName("reynolds");
        pen.setColor("white");
        
        entityManager.persist(book);
        entityManager.persist(pen);
        
        Optional<Employee> emp = employeeRepository.findById(2L);
        System.out.println(emp.isPresent());

        
    }
    
    @Test
    public void hikariConnectionPoolIsConfigured() {
        //assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
        System.out.println("the ds is "+dataSource.getClass().getName());
    }
    
    @Test
    public void getRoles() {
        //assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
        System.out.println("the roles is "+roleRepository.findAll());
    }
 
}
