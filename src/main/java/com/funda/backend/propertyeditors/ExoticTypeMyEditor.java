/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.propertyeditors;

import com.funda.backend.vo.ExoticType;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author phanic
 */
public class ExoticTypeMyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        setValue(new ExoticType(text.toUpperCase()));
    } 
}
