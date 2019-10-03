/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/hooks")
public class CleverTapWebHooks {
    

    @RequestMapping(value = "/testwebhook", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEnabledFlag(@RequestBody String profiles) {
        System.out.println(profiles);
    }
}
