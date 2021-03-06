/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author phanic
 */
@Entity
@Getter @Setter
@NamedQuery(name = "Employee.getViaCompany" , query = "SELECT t FROM Employee t WHERE t.company = :company")
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @NotBlank
    private String company;   
    
    private String salary;
    
    //@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name="created_at")
    private Date createdAt;

    //@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name="updated_at")
    private Date updatedAt;
    
    public Employee(String name,String company, String salary){
        this.name = name;
        this.company = company;
        this.salary = salary;
    }
    
    public Employee(){
    }  
    
}
