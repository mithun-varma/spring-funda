/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.jpa.repositories;

import com.funda.backend.jpa.entities.Employee;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 *
 * @author phanic
 */

/**
 * its my custom repository to keep the interface small
 * @NoRepositoryBean to prevent implementation by spring data to the below bean 
 * instead it should provide implementation to concrete classes
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> , JpaSpecificationExecutor<Employee> , QuerydslPredicateExecutor<Employee> {
 
    void delete(T deleted);
    
    void deleteAll();
 
    List<T> findAll();
     
    Optional<T> findById(ID id);
    
    T save(T persisted);
}