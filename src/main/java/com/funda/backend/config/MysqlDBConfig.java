///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.backend.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// *
// * @author phanic
// */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//    entityManagerFactoryRef = "mysqlEntityManager",
//    transactionManagerRef = "mysqlTransactionManager",
//    basePackages = { "com.funda.backend.hibernate" }
//)
//public class MysqlDBConfig {
//    
//    @Autowired
//    @Qualifier("mysql")
//    private DataSource mysqlDataSource;
//    
//    
//    @Bean(name = "mysqlEntityManager")
//    public LocalContainerEntityManagerFactoryBean oraclesqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//        .dataSource(mysqlDataSource)
//        .packages("com.funda.backend.hibernate") // you can also give the package where the Entities are given rather than giving Entity class
//        .persistenceUnit("mysqlPU")
//        .build();
//    }
// 
//    @Bean(name = "mysqlTransactionManager")
//    public PlatformTransactionManager oraclesqlTransactionManager(
//        @Qualifier("mysqlEntityManager") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//    
//}
