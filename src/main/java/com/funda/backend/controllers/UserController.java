/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.jpa.repositories.UserRepository;
import com.funda.backend.vo.User;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    
    //Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @Autowired
    public UserRepository userRepository;
 
    @PostMapping(path = "/register", produces = "application/json")
    public void register(@RequestBody @Valid User user) {
        System.out.println("came here");
        //userRepository.save(user);
    }
    
    @GetMapping(path = "/", produces = "application/json")
    public void users() {
        log.trace("A TRACE Message log4j");
        log.debug("A DEBUG Message log4j");
        log.info("An INFO Message log4j");
        log.warn("A WARN Message log4j");
        log.error("An ERROR Message log4j");
        //userRepository.save(user);
    }
}
