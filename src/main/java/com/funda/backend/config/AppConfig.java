/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.vo.Employee;
import com.funda.propertyeditors.CustomDateEditorRegistrar;
import com.funda.propertyeditors.CustomPhoneEditorRegistrar;
import javax.annotation.PostConstruct;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 *
 * @author phanic
 */
@Configuration
@ConfigurationProperties(prefix = "conversion")
public class AppConfig {
    
    private Employee employee;
    
    @PostConstruct
    public void checkInit(){
        System.out.println("the employee is "+employee.getName());
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        bean.setOrder(2);
        return bean;
    }
    
    @Bean
    public ViewResolver thymeleafViewResolver() {
 
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
 
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);
 
        // Important!!
        // th_page1.html, th_page2.html, ...
        viewResolver.setViewNames(new String[] { "th_*" });
 
        return viewResolver;
    }
 
    // Thymeleaf template engine with Spring integration
    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
 
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
 
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }
 
    // Thymeleaf template resolver serving HTML 5
    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {
 
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
 
        return templateResolver;
    }
    
    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        PropertyEditorRegistrar[] registrars = new PropertyEditorRegistrar[]{new CustomDateEditorRegistrar(),
            new CustomPhoneEditorRegistrar()
        };
        configurer.setPropertyEditorRegistrars(registrars);
        return configurer;
    }
    
}
