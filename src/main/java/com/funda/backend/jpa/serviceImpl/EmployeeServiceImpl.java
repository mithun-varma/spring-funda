/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.serviceImpl;

import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.QEmployee;
import com.funda.backend.jpa.predicates.EmployeePredicates;
import com.funda.backend.jpa.repositories.EmployeeRepository;
import com.funda.backend.jpa.services.EmployeeService;
import com.funda.backend.jpa.specifications.EmployeeSpecifications;
import com.querydsl.core.types.Predicate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phanic
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findBySearchTerm(String searchTerm) {
        Specification<Employee> salariedEmployees = EmployeeSpecifications.hasSalaryEqualOrMore("500");
        Specification<Employee> companyWiseEmployees = EmployeeSpecifications.withCompany("HII");
        List<Employee> employees = repository.findAll(Specification.where(salariedEmployees).and(companyWiseEmployees));
        return employees;

    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Employee> findBySalary(String salary) {
        Predicate salgoe = EmployeePredicates.salaryGoe(salary);
        Iterable<Employee> employees = repository.findAll(salgoe);
        return employees;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Employee> findByCompanyAndName(String company,String nameExp) {
        Predicate compAndName = EmployeePredicates.companyAndName(company, nameExp);
        Iterable<Employee> employees = repository.findAll(compAndName);
        return employees;
    }

}
