/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

import java.math.BigDecimal;

/**
 *
 * @author phanic
 */
public class Item extends Entity{
    private final String itemName;
    private final BigDecimal cost;

    public Item (String id, String itemName, BigDecimal cost) {
        super(id);
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getCost() {
        return cost;
    }
    
    
}
