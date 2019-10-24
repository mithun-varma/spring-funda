/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.jpa.repositories.UserRepository;
import com.funda.backend.vo.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
    @Autowired
    public UserRepository userRepository;
 
    @PostMapping(path = "/register", produces = "application/json")
    public void register(@RequestBody @Valid User user) {
        System.out.println("came here");
        //userRepository.save(user);
    }
}
