/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.repositories.BaseRepository;
import com.funda.backend.jpa.entities.Privilege;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */
@Repository
public interface PrivilegeRepository extends BaseRepository<Privilege, Long>{
    Optional<Privilege> findByName(String name);
}
