/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

/**
 *
 * @author phanic
 */
public class AuthUser {
    private String username;
    private String password;
    
    public AuthUser(String name){
        this.username = name;
    }

    public  String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public  String toString() {
        return username;
    }
}
