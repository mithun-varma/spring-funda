/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.exceptions;

import com.funda.backend.vo.ResponseDTO;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author phanic
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDTO onConstraintValidationException(
            ConstraintViolationException e) {
        System.out.println("came to constraint violation");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDTO onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        System.out.println("came to MethodArgumentNotValidException" + e);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }
    
    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView AccessDeniedException(
            AccessDeniedException e) {
        System.out.println("came to AccessDeniedException" + e);
        return new ModelAndView("redirect:/accessDenied");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDTO generalException(
            Exception e) {
        System.out.println("came to generalException " + e);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(HttpStatus.BAD_REQUEST.toString());
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }
}
