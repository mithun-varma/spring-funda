/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.controllers;

import com.funda.backend.exceptions.ResourceNotFoundException;
import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.Person;
import com.funda.backend.jpa.repositories.EmployeeRepository;
import com.funda.backend.jpa.services.EmployeeService;
import com.funda.backend.jpa.specifications.EmployeeSpecifications;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/api")
public class EmployeeEntityController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    
    @GetMapping("/employees")
    public List<? extends Person> getAllNotes() {
        return employeeRepository.findAll();
    }

    @PostMapping("/create")
    public Employee createNote(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Person getEmployeeById(@PathVariable(value = "id") Long noteId) {
        return employeeRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @Transactional
    @GetMapping("/employee/test")
    public void testEmployee(@RequestParam("id") Long id, @RequestParam("createdDate") String date) {
        Date convertedDate = null;
        try {
            convertedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println("the date is "+convertedDate.toInstant());

        employeeRepository.findAll().stream().forEach(action -> {
            employeeRepository.findByCompany("HII").stream().forEach(employee -> {
                System.out.println("the emp name is " + employee.getName());
            });
        });
        
        

        try(Stream<Employee> employees = employeeRepository.findByCreatedAt(convertedDate)){
            employees.forEach(action -> {
                System.out.println(" the employee is " + action.getName());
            });
        };

        Optional<String> employee = employeeRepository.findEmployeeById(id);
        System.out.println("the employee is " + employee.get());
        
        Optional<Employee> employeePositionBased = employeeRepository.findBySalaryAndCompanyPositionBased("1000" , "HII");
        System.out.println(" position based "+employeePositionBased.get().getName());

        employeeRepository.findBySalaryAndCompanyNamed("3000" , "HII").forEach(action -> {
            System.out.println(" name based "+action.getName());
        });
        
        System.out.println("named query ex");
        
        employeeRepository.getViaCompany("HII").get().forEach(action -> {
            System.out.println(" named query from props "+action.getName());
        });
        
        List<Employee> jpaEmployees = employeeService.findBySearchTerm("test");
        System.out.println("the employess are "+jpaEmployees.size());
        
        Iterable<Employee> qdlsEmployees = employeeService.findBySalary("1200");
        qdlsEmployees.forEach(action -> {
            System.out.println(" qdls emp "+action.getName());
        });
        
        Iterable<Employee> qdlsCAndN = employeeService.findByCompanyAndName("HII", "A");
        qdlsEmployees.forEach(action -> {
            System.out.println(" qdls C and N "+action.getName());
        });
        
        employeeRepository.findByNameContainsAllIgnoreCaseOrderByNameAsc("S").forEach(action -> {
            System.out.println("the sorted emp is "+action.getName());
        });
        
        employeeRepository.findAll(orderBy()).forEach(action -> {
            System.out.println("the sorted emp is "+action);
        });

    }
    
    private Sort orderBy() {
        return new Sort(Sort.Direction.ASC, "name");
    }
}
