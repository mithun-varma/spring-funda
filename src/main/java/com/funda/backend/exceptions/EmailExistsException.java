package com.funda.backend.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phanic
 */
public class EmailExistsException  extends RuntimeException{
    public EmailExistsException(String message) {
        super(message);
    }
}