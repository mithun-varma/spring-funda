/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

import java.util.Date;

/**
 *
 * @author phanic
 */
public class Employee {
    
    private String name;
    private double salary;
    private int id;
    private String role;
    private Phone phone;
    private Date doj;
    private ExoticType exoticType;
    
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public Employee(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    } 

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }   

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public ExoticType getExoticType() {
        return exoticType;
    }

    public void setExoticType(ExoticType exoticType) {
        this.exoticType = exoticType;
    }
    
    
    
}
