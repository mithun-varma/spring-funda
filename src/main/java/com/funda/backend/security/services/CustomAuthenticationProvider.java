/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security.services;

import com.funda.backend.exceptions.BadCredentialsException;
import com.funda.backend.jpa.entities.Role;
import com.funda.backend.jpa.entities.User;
import com.funda.backend.jpa.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phanic
 */
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        String name = a.getName();
        Object credentials = a.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        System.out.println("credentials : " + name + " pwd " + password);
        Optional<User> userOptional = userRepository.findByUsername(name);
        if (!userOptional.isPresent()) {
            //throw new BadCredentialsException("Authentication failed for " + name);
            return null;
        }
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, getAuthorities(userOptional.get().getRoles()));
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {

        List<GrantedAuthority> authorities
                = new ArrayList<>();
        roles.stream().forEachOrdered((role) -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPrivileges().stream()
                .map(p -> new SimpleGrantedAuthority(p.getName()))
                .forEach(authorities::add);
        });
        return authorities;
    }

}
