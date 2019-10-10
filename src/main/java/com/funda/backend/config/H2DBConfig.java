///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.backend.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import org.dom4j.Branch;
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
//    entityManagerFactoryRef = "h2EntityManager",
//    transactionManagerRef = "h2TransactionManager",
//    basePackages = { "com.funda.backend.hibernate" }
//)
//public class H2DBConfig {
//    
//    @Autowired
//    private DataSource dataSource;
//
//    @Primary
//    @Bean(name = "h2EntityManager")
//    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//            .dataSource(dataSource)
//            .packages("com.funda.backend.hibernate")
//            .persistenceUnit("h2PU")
//            .build();
//    }
//
//    @Primary
//    @Bean(name = "h2TransactionManager")
//    public PlatformTransactionManager mysqlTransactionManager(
//        @Qualifier("h2EntityManager") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
