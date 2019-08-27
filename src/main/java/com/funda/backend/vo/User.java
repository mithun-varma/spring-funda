/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

import com.funda.backend.annotations.UniqueLogin;
import java.util.Objects;

/**
 *
 * @author phanic
 */
public class User {

    @UniqueLogin
    private String login;
    private char[] password;

    private User() {
        // no-arg Jackson constructor
    }

    public User(String login, char[] password) {
        Objects.requireNonNull(login);
        Objects.requireNonNull(password);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
