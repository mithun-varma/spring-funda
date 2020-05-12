/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.custompropertyeditors.vo.ExoticType;
import com.funda.backend.custompropertyeditors.ExoticTypeMyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author phanic
 */
@ControllerAdvice
public class GlobalBindings {
    @InitBinder
    public void globalBind(WebDataBinder webBinder){
        webBinder.registerCustomEditor(ExoticType.class, new ExoticTypeMyEditor());
    }
}
