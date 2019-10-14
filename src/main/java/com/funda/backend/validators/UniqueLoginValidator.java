/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.validators;

import com.funda.backend.annotations.UniqueLogin;
import com.funda.backend.hibernate.repositories.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author phanic
 */
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
 
    private UserRepository userRepository;
 
    public UniqueLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Override
    public void initialize(UniqueLogin constraint) {
    }
 
    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !userRepository.findByLogin(login).isPresent();
    }
 
}
