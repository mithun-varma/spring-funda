/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.propertyeditors;

import com.funda.backend.vo.Phone;
import com.funda.backend.vo.PhoneType;
import java.beans.PropertyEditorSupport;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component
public class CustomPhoneNumberEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text){
        System.out.println("the set as text called");
        String[] split = text.split("[|]");
        if (split.length != 2) {
            throw new IllegalArgumentException(
                "Phone is not correctly defined. The correct format is " +
                "PhoneType | 111-111-1111");
        }
        PhoneType phoneType = PhoneType.valueOf(split[0].trim()
                                                        .toUpperCase());
        Phone phone = new Phone();
        phone.setPhoneType(phoneType);
        phone.setPhoneNumber(split[1].trim());
        setValue(phone);
    }
    
}
