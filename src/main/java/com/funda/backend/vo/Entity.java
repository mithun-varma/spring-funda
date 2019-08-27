/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.vo;

/**
 *
 * @author phanic
 */
public abstract class Entity {
   private final String id;

   public Entity (String id) {
       this.id = id;
   }
}
