/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.controllers;

import com.funda.backend.jpa.serviceApi.JPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/jpa")
public class JPAGeneralEntityController {
    
    @Autowired
    private JPAService jpaServjpaServiceice;
    
    
    @GetMapping("/saveS&G")
    public void saveStudentAndGuide(){
        jpaServjpaServiceice.saveStudentAndGuide();
    }
    
    @GetMapping("/testSingleTableInheritance")
    public void testSingleTableInhertance(){
        jpaServjpaServiceice.testSingleTableInhertance();
    }
}
