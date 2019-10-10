/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.hibernate.controllers;

import com.funda.backend.exceptions.ResourceNotFoundException;
import com.funda.backend.hibernate.entities.Employee;
import com.funda.backend.hibernate.entities.Person;
import com.funda.backend.hibernate.repositories.EmployeeRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
