/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.custompropertyeditors;

import com.funda.backend.custompropertyeditors.vo.ExoticType;
import com.funda.backend.custompropertyeditors.CustomDateEditorRegistrar;
import com.funda.backend.custompropertyeditors.CustomPhoneEditorRegistrar;
import com.funda.backend.custompropertyeditors.ExoticTypeMyEditor;
import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author phanic
 */
@Configuration
public class PropertyEditorConf {
    
    @PostConstruct
    public void checkInit() {
        System.out.println("the employee is test");
    }
    
    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        try{
            CustomEditorConfigurer configurer = new CustomEditorConfigurer();
            PropertyEditorRegistrar[] registrars = new PropertyEditorRegistrar[]{new CustomDateEditorRegistrar(),
                new CustomPhoneEditorRegistrar()
            };
            configurer.setPropertyEditorRegistrars(registrars);
            return configurer;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
