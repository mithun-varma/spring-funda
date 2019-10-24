/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security.controllers;

import com.funda.backend.annotations.CurrentlyLoggedUser;
import com.funda.backend.jpa.entities.User;
import com.funda.backend.security.services.CommonSecurityServices;
import com.funda.backend.vo.AuthUser;
import com.funda.backend.vo.UserForm;
import java.security.Principal;
import java.time.LocalTime;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author phanic
 */
@Controller
@RequestMapping("/auth")
public class SecurityAuthController {
    
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private CommonSecurityServices sercurityServices;
    

    @GetMapping("/checkAuthentication")
    public void validateRequestParameter(Principal principal ,
            Authentication authentication ,@CurrentlyLoggedUser AuthUser domainUser) {
        String name = principal.getName();
        System.out.println("the name is "+name+" auth "+authentication.getAuthorities()+" "+authentication.getName()
        +" domain user "+domainUser);
    }
    
    @RequestMapping("/roles")
    public String handleRequest2(HttpServletRequest request, Model model) {
        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();
        model.addAttribute("uri", request.getRequestURI())
             .addAttribute("user", auth.getName())
             .addAttribute("roles", auth.getAuthorities())
             .addAttribute("time", LocalTime.now());
        return "roles";
    }
    
    @GetMapping(path = "/register")
    public String displayUserRegistration(ModelMap model) {
        model.put("userForm", new User());
        return "adminUserRegistration";
    }
    
    

    @PostMapping(path = "/register", produces = "application/json")
    public String register(@Valid User user , BindingResult result) {
            System.out.println(" register admin user "+user.getFirstName());
            if (result.hasErrors()) {
                System.out.println("there are errors");
            } else {
                sercurityServices.registerNewUserAccount(user);
                System.out.println("error free registration");
            }
        return "studentSuccessfulRegistration";
    }
}
