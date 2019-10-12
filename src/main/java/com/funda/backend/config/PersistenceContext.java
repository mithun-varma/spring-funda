/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

/**
 *
 * @author phanic
 */
@Configuration
public class PersistenceContext {
    
    @Bean(destroyMethod = "close")
    @Primary
    DataSource dataSource(Environment env) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
 
        return new HikariDataSource(dataSourceConfig);
    }
    
    @Bean
    @Qualifier("mysql")
    public DataSource oraclesqlDataSource(Environment env)  {
        //ComboPooledDataSource dataSource = new ComboPooledDataSource("primary");
        HikariConfig dataSource = new HikariConfig();
        dataSource.setDriverClassName(env.getRequiredProperty("mysql.db.driver"));
        dataSource.setJdbcUrl(env.getRequiredProperty("mysql.db.url"));
        dataSource.setUsername(env.getRequiredProperty("mysql.db.username"));
        dataSource.setPassword(env.getRequiredProperty("mysql.db.password"));
        /*dataSource.setMinPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.max_size")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.min_size")));
        dataSource.setMaxIdleTime(Integer.parseInt(env.getRequiredProperty("c3p0.idle_test_period")));*/
        return new HikariDataSource(dataSource);

        //return dataSource;
    }
}
