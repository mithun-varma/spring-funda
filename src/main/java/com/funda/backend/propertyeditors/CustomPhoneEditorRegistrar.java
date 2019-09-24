/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.propertyeditors;

import com.funda.backend.vo.Phone;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component(value = "phoneRegistrar")
public class CustomPhoneEditorRegistrar implements PropertyEditorRegistrar{
    @Override
    public void registerCustomEditors(PropertyEditorRegistry per) {
        per.registerCustomEditor(Phone.class, new CustomPhoneNumberEditor());
    }
}
