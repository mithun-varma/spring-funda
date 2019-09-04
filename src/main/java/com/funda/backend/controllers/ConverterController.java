/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.config.Modes;
import com.funda.backend.vo.Employee;
import com.funda.backend.vo.Entity;
import com.funda.backend.vo.Item;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phanic
 */
@RestController
public class ConverterController {
    
    private static final Logger logger = Logger.getLogger(ConverterController.class);

    @Autowired
    private ConversionService service;

    
    public Entity getEntity (String entityId, Class<? extends Entity> type) {
        return service.convert(entityId, type);
    }
    
    @GetMapping("/string-to-employee")
     public Map<String ,String > getEmployee(@RequestParam("employee") Employee emp) {
         Map<String,String> response = new HashMap<>();
         try {
             System.out.println(" the conversion for emp "+emp.getName());
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }

        return response;
     }
    
    @GetMapping("string-to-entity")
     public Map<String ,String > getEntity(@RequestParam("id") Item order) {
         Map<String,String> response = new HashMap<>();
         try {
             System.out.println(" the conversion for emp "+order.getItemName());
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }

        return response;
     }
     
     @GetMapping("/test-entity")
     public Map<String ,String > testEntiry() {
         Map<String,String> response = new HashMap<>();
         try {
             //Entity item = getEntity("131", Item.class);
             Item a = service.convert("5000", Item.class);
             Enum m = service.convert("ALPHA", Modes.class);
             System.out.println(" the conversion for emp "+m);
            response.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }

        return response;
     }
}
