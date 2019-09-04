/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.annotations;

import com.funda.backend.validators.FieldsMatchValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author phanic
 */
@Constraint(validatedBy = FieldsMatchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FieldsMatch {
    String message() default "Fields values don't match!";
 
    String field();
 
    String fieldMatch();
 
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
    
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsMatch[] value();
    }
}
