/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.services;

import com.funda.backend.jpa.entities.Employee;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author phanic
 */
public interface EmployeeService {
    List<Employee> findBySearchTerm(String searchTerm);
    
    //@PreAuthorize("hasRole('USER')")
    Iterable<Employee> findBySalary(String salary);
    
    Iterable<Employee> findByCompanyAndName(String comp, String name);
    

}
