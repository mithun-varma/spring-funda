/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.services;

import com.funda.backend.jpa.entities.Employee;
import java.util.List;

/**
 *
 * @author phanic
 */
public interface EmployeeService {
    List<Employee> findBySearchTerm(String searchTerm);
}
