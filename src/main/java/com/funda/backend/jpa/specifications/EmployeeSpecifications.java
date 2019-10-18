/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.specifications;

import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.Employee_;
import java.util.function.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author phanic
 */
public class EmployeeSpecifications {
    public static Specification<Employee> hasSalaryEqualOrMore(String salary) {
        /*return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,                                 
                CriteriaQuery<?> query, 
                CriteriaBuilder cb) {
                //Create the query here.
                
            }
        }*/
        return (root,query ,cb) -> {
            return cb.greaterThanOrEqualTo(root.get(Employee_.SALARY), Integer.parseInt(salary));
        };
    }
    
    public static Specification<Employee> withCompany(String company) {
        return (root,query ,cb) -> {
            return cb.equal(root.get(Employee_.COMPANY), company);
        };
    }
}
