/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security.controllers;

import com.funda.backend.annotations.CurrentlyLoggedUser;
import com.funda.backend.vo.AuthUser;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/auth")
public class SecurityAuthController {
    
    @Autowired
    private ApplicationContext context;
    

    @GetMapping("/checkAuthentication")
    public void validateRequestParameter(Principal principal ,Authentication authentication ,@CurrentlyLoggedUser AuthUser domainUser) {
        String name = principal.getName();
        System.out.println("the name is "+name+" auth "+authentication.getAuthorities()+" "+authentication.getName()
        +" domain user "+domainUser);
    }

}
