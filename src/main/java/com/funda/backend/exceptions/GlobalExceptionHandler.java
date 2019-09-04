/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.exceptions;

import com.funda.backend.vo.ResponseDTO;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author phanic
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {
        System.out.println("came to constaint validation handler ");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(responseDTO);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> handlerRunTimeError(Exception ex, WebRequest request) {
        System.out.println("came to constaint validation handler "+ex);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(responseDTO);
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        System.out.println("came to exception"+ex);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(ex.getMessage());
        return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
