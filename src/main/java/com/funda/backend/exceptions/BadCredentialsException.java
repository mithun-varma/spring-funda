/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.exceptions;

/**
 *
 * @author phanic
 */
public class BadCredentialsException extends RuntimeException{
    public BadCredentialsException(String message) {
        super(message);
    }
}
