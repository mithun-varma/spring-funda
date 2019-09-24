/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.propertyeditors;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component
@EnableConfigurationProperties
public class CustomDateEditorRegistrar implements PropertyEditorRegistrar{
    @Override
    public void registerCustomEditors(PropertyEditorRegistry per) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        per.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
    }
    
}
