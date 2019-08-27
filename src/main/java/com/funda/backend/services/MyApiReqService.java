/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.services;

import com.funda.backend.dao.MyReqDAO;
import com.funda.backend.entities.ApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author phanic
 */
@Service
@Transactional
public class MyApiReqService {

    @Autowired
    private MyReqDAO apiRequestDao;

    public void create(ApiRequest apiRequest) {
        apiRequestDao.create(apiRequest);
    }
}
