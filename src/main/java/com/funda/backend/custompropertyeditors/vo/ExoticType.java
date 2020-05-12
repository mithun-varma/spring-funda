/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.custompropertyeditors.vo;

/**
 *
 * @author phanic
 */
public class ExoticType {

    private String name;
    private String exoticTypeName;
    private String value;

    public ExoticType(String name) {
        this.exoticTypeName = name;
    }

    public String getExoticTypeName() {
        return exoticTypeName;
    }

    public void setExoticTypeName(String exoticTypeName) {
        this.exoticTypeName = exoticTypeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
    

}
