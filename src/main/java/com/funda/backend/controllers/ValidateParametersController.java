/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.vo.DependsOnExoticType;
import com.funda.backend.propertyeditors.CustomPhoneNumberEditor;
import com.funda.backend.propertyeditors.ExoticTypeMyEditor;
import java.beans.PropertyEditor;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@Validated
public class ValidateParametersController {
    
    @Autowired
    private ApplicationContext context;
    

    @GetMapping("/validatePathVariable/{id}")
    ResponseEntity<String> validatePathVariable(
            @PathVariable("id") @Min(5) int id) {
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/validateRequestParameter")
    ResponseEntity<String> validateRequestParameter(
            @RequestParam("param") @Min(5) int param ,HttpSession session) {
        String id = session.getId();
        if(session.getAttribute(id) != null){
            System.out.println("session is "+session.getAttribute(id));
        }else{
            System.out.println("creating session ");
            session.setAttribute(session.getId(), param);
        }

        return ResponseEntity.ok("valid");
    }
    
    @PostMapping("/test-exotic")
     public void testExotic(DependsOnExoticType type) {

        PropertyEditor editor = context.getBean(CustomPhoneNumberEditor.class);
        editor.setAsText("testing phase");
        String value = (String) editor.getValue();
        System.out.println(value);

     }

}
