/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.vo.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author phanic
 */

@Controller
@RequestMapping("/")
public class HelloController {
    
    @Autowired
    MailTemplate mailTemplate;
    
    @RequestMapping("/home")
    public String index(ModelMap model) {
        System.out.println("Hello world");
        System.out.println(" test template values "+mailTemplate.getHostName()+" "+mailTemplate.getPort());	
        model.addAttribute("welcome_message", "Welcome come to Spring platform Portal");
        return "th_login";
    }
    
    @RequestMapping("/")
    public String home(ModelMap model) {
        System.out.println(" default login "+mailTemplate.getHostName()+" "+mailTemplate.getPort());	
        model.addAttribute("welcome_message", "Welcome come to Spring platform Portal");
        return "login";
    }
    
    
    @PostMapping(path = "/login")
    public String register(ModelMap model, @RequestParam String name, @RequestParam String password) {
        System.out.println("came here usr "+name+" pwd "+password);
        model.put("name", name);
        model.put("password", password);    
        return "welcome";
    }

}
