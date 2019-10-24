/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.repositories.BaseRepository;
import com.funda.backend.jpa.entities.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */
@Repository
public interface RoleRepository extends BaseRepository<Role, Long>{
    public Role findByName(String name);
}
