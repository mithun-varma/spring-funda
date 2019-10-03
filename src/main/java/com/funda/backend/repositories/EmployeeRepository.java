/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.repositories;

import com.funda.backend.hibernate.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
