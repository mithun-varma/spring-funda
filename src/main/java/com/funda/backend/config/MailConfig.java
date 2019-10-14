/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.vo.MailTemplate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author phanic
 */
@Configuration
//@PropertySource("file:/opt/${mail.path:cdc}/mail.properties") // if not given will default to application.props
@PropertySource("classpath:mail.properties") // if not given will default to application.props
@ConfigurationProperties(prefix = "mail") // requires setter and getter methods
public class MailConfig {
    
    private String hostName;
    private int port;
    private String from;
    
    @Autowired
    Environment env;
    
    @Autowired
    MyAppProperties appProps;

    @PostConstruct
    public void testMailProps() {
        System.out.println("env props "+env.getProperty("mail.hostname")+" "+env.getProperty("mail.port")
            +" "+env.getProperty("active.env")+" "+env.getProperty("mail.app.trade-start-date"));
        System.out.println("the props are "+hostName+" "+port+" "+from+" app props "+getAppProps().getTradeStartDate());
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }
    
    @Bean
    @ConfigurationProperties(prefix = "mail") //have to specify 
    public MailTemplate getMailTemplate(){
        return new MailTemplate();
    }
    
    @Bean
    @ConfigurationProperties(prefix = "mail.app") //have to specify 
    public MyAppProperties getAppProps(){
        return new MyAppProperties();
    }
      
}
