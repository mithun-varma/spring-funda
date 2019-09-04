///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.backend.controllers;
//
//import com.funda.backend.entities.ApiRequest;
//import com.funda.backend.services.MyApiReqService;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author phanic
// */
//@RestController
//public class MyRequestController {
//    
//    @Autowired
//    private MyApiReqService apiRequestService; 
//    
//    private static final Logger logger = Logger.getLogger(MyApiReqService.class);
//    
//     @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//     public Map<String ,String > getHome() {
//         Map<String,String> response = new HashMap<>();
//         try {
//            ApiRequest apiRequest = new ApiRequest(new Date());
//            apiRequestService.create(apiRequest);
//            response.put("status", "success");
//        } catch (Exception e) {
//            logger.error("Error occurred while trying to process api request", e);
//            response.put("status", "fail");
//        }
//
//        return response;
//     }
//     
//}
