/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.dao;

import com.funda.backend.entities.ApiRequest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author phanic
 */
@Repository
public class MyReqDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(ApiRequest apiRequest) {
        entityManager.persist(apiRequest);
    }

    public void update(ApiRequest apiRequest) {
        entityManager.merge(apiRequest);
    }

    public ApiRequest getApiRequestById(long id) {
        return entityManager.find(ApiRequest.class, id);
    }

    public void delete(long id) {
        ApiRequest apiRequest = getApiRequestById(id);
        if (apiRequest != null) {
            entityManager.remove(apiRequest);
        }
    }
}
