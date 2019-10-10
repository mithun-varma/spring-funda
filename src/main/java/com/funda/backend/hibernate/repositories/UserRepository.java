/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.hibernate.repositories;

import com.funda.backend.vo.User;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */

@Repository
public class UserRepository {

    private List<User> registeredUsers = new LinkedList<>();

    public void save(User user) {
        registeredUsers.add(user);
    }

    public Optional<User> findByLogin(String login) {
        return registeredUsers.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }

}
