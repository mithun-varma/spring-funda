/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.config;

import com.funda.backend.converters.EmployeeConverter;
import com.funda.backend.converters.IdToEntityConverterFactory;
import com.funda.backend.converters.StringToEnumConverterFactory;
import com.funda.backend.methodargresolvers.HeaderVersionArgumentResolver;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
public class MvcResolver implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmployeeConverter());
        registry.addConverterFactory(new StringToEnumConverterFactory());
        registry.addConverterFactory(new IdToEntityConverterFactory());

    }

//    @Override
//    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
//        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
//        initializer.setPropertyEditorRegistrar(propertyEditorRegistry -> {
//            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//            propertyEditorRegistry.registerCustomEditor(Date.class,
//                    new CustomDateEditor(dateFormatter, true));
//        });
//        return initializer;
//    }
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HeaderVersionArgumentResolver());
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
        viewResolver.setViewNames(new String[]{"th_*"});

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
    
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//            "classpath:/resources/",
//            "classpath:/static/", "classpath:/public/" };
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//    }
}
