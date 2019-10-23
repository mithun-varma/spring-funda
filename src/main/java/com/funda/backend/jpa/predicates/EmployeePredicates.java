/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.predicates;

import com.funda.backend.jpa.entities.Employee;
import com.funda.backend.jpa.entities.QEmployee;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

/**
 *
 * @author phanic
 */
public class EmployeePredicates {

    private EmployeePredicates() {
    }

    public static Predicate salaryGoe(String salary) {
        QEmployee employee = QEmployee.employee;
        PathBuilder<Employee> entityPath = new PathBuilder<>(Employee.class, "employee");
        StringPath path = entityPath.getString("salary");
        //NumberPath<Integer> path = entityPath.getNumber("salary", Integer.class);
        //int val = Integer.parseInt(salary);
        Predicate salgoe = path.goe(salary);
        //Predicate salgoe = employee.salary.goe(salary);
        return salgoe;
    }

    public static Predicate companyAndName(String company, String name) {
        QEmployee employee = QEmployee.employee;
        Predicate compAndName = employee.company.eq(company)
                .and(employee.name.like(name));
        return compAndName;
    }
}
