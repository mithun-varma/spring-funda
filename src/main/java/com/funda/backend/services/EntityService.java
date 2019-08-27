/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.services;

import com.funda.backend.vo.Entity;
import com.funda.backend.vo.Item;
import com.funda.backend.vo.Order;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author phanic
 */
//just a test service
@Service
public class EntityService {

    public <T extends Entity> T getEntity(String id,
            Class<T> targetType) {
        if (targetType == Item.class) {
            return (T) findItemById(id);
        } else if (targetType == Order.class) {
            return (T) findOrderById(id);
        } 
        return null;
    }

    private Order findOrderById(String id) {
        return new Order(id, 400, new Date());

    }

    private Item findItemById(String id) {
        return new Item(id, "some tiem", new BigDecimal(100));
    }
}
