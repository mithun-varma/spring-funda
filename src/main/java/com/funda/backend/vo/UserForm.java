/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

import com.funda.backend.annotations.FieldsMatch;

/**
 *
 * @author phanic
 */

@FieldsMatch.List(value = {
    @FieldsMatch(
      field = "password", 
      fieldMatch = "verifyPassword", 
      message = "Passwords do not match!"
    ), 
    @FieldsMatch(
      field = "email", 
      fieldMatch = "verifyEmail", 
      message = "Email addresses do not match!"
    )
})
public class UserForm {
    
    private String email;
    private String verifyEmail;
    private String password;
    private String verifyPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(String verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
    
    
}
