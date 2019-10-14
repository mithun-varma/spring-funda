/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 *
 * @author 91984
 * @param <T>
 * @param <ID>
 */

@NoRepositoryBean
public interface CommonBaseRepository<T, ID extends Serializable> extends Repository<T, ID>{
    void delete(T deleted);
 
    List<T> findAll();
     
    Optional<T> findOne(ID id);
 
    T save(T persisted);
}
