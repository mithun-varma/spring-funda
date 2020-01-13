/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author phanic
 */
@Entity
public class Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;
    @Column(name = "birth_date")
    private Date birthDate;
    
    public Person(){
        
    }
    
    public Person(String name){
        this.name = name;
        this.location = null;
        this.birthDate = null;
    }
   
    public Person(String name, String location, Date birthDate){
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
     
    public Person(long id ,String name, String location, Date birthDate){
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public void setPersonId(long personId) {
        this.id = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
