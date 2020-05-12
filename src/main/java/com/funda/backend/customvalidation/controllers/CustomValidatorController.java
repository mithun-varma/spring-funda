/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.customvalidation.controllers;

import java.time.LocalDateTime;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/customvalidation")
public class CustomValidatorController {

    @Autowired
    ValidationService validationService;

    @GetMapping(path = "/spring_validated")
    public void testSpringValidated() {
        try {
            String status = validationService.createReport("", LocalDateTime.now().minusMinutes(30));
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            throw e;
        }
    }
    
    @GetMapping(path = "/spring_validated_valid")
    public void testSpringValidatedValid() {
        try {
            UserVo user = new UserVo();
            user.setEmail("tony-example.com");      
            validationService.registerUser(user);
        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
            throw e;
        }
    }
}
