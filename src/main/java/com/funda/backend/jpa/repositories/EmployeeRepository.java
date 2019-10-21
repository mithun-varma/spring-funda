/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.specifications.EmployeeSpecifications;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phanic
 */
@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long> , JpaSpecificationExecutor<Employee> {
    public List<Employee> findByCompany(String company);
     
    @Query("SELECT t.salary FROM Employee t where t.id = :id") 
    Optional<String> findEmployeeById(@Param("id") Long id);
    
    @Query("select a from Employee a where a.createdAt >= :creationAt")
    Stream<Employee> findByCreatedAt(@Param("creationAt") Date creationAt);
    
    @Query(value = "SELECT e FROM Employee e where e.salary = ?1 AND e.company = ?2")
    public Optional<Employee> findBySalaryAndCompanyPositionBased(String salary, String company);
    
    @Query(value = "SELECT e FROM Employee e where e.salary = :salary AND e.company = :company")
    public Optional<Employee> findBySalaryAndCompanyNamed(@Param("salary")String salary,@Param("company") String company);
    
    @Query(name = "Employee.getViaCompany")
    public Optional<Stream<Employee>> getViaCompany(@Param("company") String company);
      
}
