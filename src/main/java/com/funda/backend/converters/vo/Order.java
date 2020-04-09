/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.converters.vo;

import java.util.Date;

/**
 *
 * @author phanic
 */
public class Order extends Entity{
    
    private final int quantity;
    private final Date date;

    public Order (String id, int quantity, Date date) {
        super(id);
        this.quantity = quantity;
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }
    
    
    
}
