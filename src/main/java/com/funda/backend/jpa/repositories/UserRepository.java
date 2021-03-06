/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.repositories.BaseRepository;
import com.funda.backend.jpa.entities.User;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */
@Repository
@Primary
public interface UserRepository extends BaseRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String name);
}
