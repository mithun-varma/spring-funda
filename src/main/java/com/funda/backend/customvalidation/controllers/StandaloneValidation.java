///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.backend.customvalidation.controllers;
//
//import java.time.LocalDateTime;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.validation.Validator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
//
///**
// *
// * @author phanic
// */
//@Configuration
//public class StandaloneValidation {
//    
//    @Bean
//    public Alternative getBean(){
//        return new Alternative();
//    }
//    
//    @Bean
//    public ValidationService getValidationService(){
//        return new ValidationService();
//    }
//    
//    @Bean
//    public Validator validatorFactory() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        return new MethodValidationPostProcessor();
//    }
//    
//    public static void main(String[] args) {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(StandaloneValidation.class);
//        
//        Alternative service = context.getBean(Alternative.class);
//        service.test();
//
//    }
//
//    class Alternative {
//        
//        @Autowired
//        ValidationService validationService;
//
//        public void test() {
//            System.out.println("-- calling ReportTask#createReport() --");
//            System.out.println("-- with invalid parameters --");
//            try {
//                String status = validationService.createReport("", LocalDateTime.now().minusMinutes(30));
//                System.out.println(status);
//            } catch (ConstraintViolationException e) {
//                for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//                    System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
//                }
//            }
//            System.out.println("-- with valid parameters but invalid return value --");
//            try {
//                String status = validationService.createReport("create reports", LocalDateTime.now().plusMinutes(30));
//                System.out.println(status);
//            } catch (ConstraintViolationException e) {
//                for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//                    System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
//                }
//            }
//
//            System.out.println("-- calling UserTask#registerUser() --");
//            UserVo user = new UserVo();
//            user.setEmail("tony-example.com");
//            try {
//                validationService.registerUser(user);
//            } catch (ConstraintViolationException e) {
//                for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//                    System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
//                }
//            }
//
//        }
//    }
//}
