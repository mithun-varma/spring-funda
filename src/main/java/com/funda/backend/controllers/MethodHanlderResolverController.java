/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.methodargresolvers.Version;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
@RequestMapping("/argresolver")
public class MethodHanlderResolverController {

    @GetMapping("/entity/{id}")
    public ResponseEntity findByVersion(
    @PathVariable Long id, @Version String version) {
        System.out.println("the version si "+version);
        return new  ResponseEntity(HttpStatus.OK);
}
}
