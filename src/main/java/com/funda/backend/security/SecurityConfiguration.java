/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security;

import com.funda.backend.security.services.CustomAuthenticationProvider;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 *
 * @author phanic
 */
/**
 * when using single configuration(i.e only one config for entire module ) use
 * autowire for either (configureGlobalSecurity , configureGlobal,
 * registerGlobal ) else override by extending WebSecurityConfigurerAdapter in a
 * separate class
 *
 *
 * UserDetailsService and AuthenticationProvider are 2 different things (one is
 * dao for user data fetches the data) the other authenticates the data with
 * userDetailsService impl you get username
 *
 * BasicAuth BasicAuthFilter checks for header Authrorization if not present it
 * spring security raises access denied exception handled by
 * ExceptionTranslationFilter , A BasicAuthenticationEntryPoint strategy is also
 * configured into the ExceptionTranslationFilter on startup which responds with
 * Basic Realm which is necessary, you can override and implement your own custom
 * Entry point strategy by implementing BasicAuthenticationEntryPoint interface
 * for customization of authentication failure response
 *
 *
 * # authentication flow AbstractSecurityInterceptor along with
 * AccessDecisionManager -> if(error ){ if resource is protected and
 * authentication is not provided exception is thrown if it is some sub class of
 * AuthenticationException then ExceptionTranslationFilter ->
 * AuthenticationEntryPoint -> we build custom response if we override this
 * method with (401) and some custom headers(Basic Realm) such that dialog is
 * displayed in browser
 *
 * }else{
 *
 *
 * }
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private AuthenticationProvider authenticationProvider;
    
    @Autowired
    private UserDetailsService userDetailsService;

    /*@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("mith").password("ace2three").roles("ADMIN");
    }*/
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPwd = encoder.encode("ace2three");
        //In Memory Auth
//        auth.inMemoryAuthentication().withUser("mith").password(encodedPwd).roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}ace2three").roles("ADMIN");
        //JDBC Auth
//        auth.jdbcAuthentication().dataSource(dataSource);
//        .withDefaultSchema().withUser("mith").password(encodedPwd).roles("USER");
        //Custom Authentication Provider
//        auth.authenticationProvider(authenticationProvider);
        //User Details Service
        auth.userDetailsService(userDetailsService);

    }

    //DataSource Configure
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
        .headers().frameOptions().sameOrigin()
        .and().authorizeRequests()
        .antMatchers("/home").permitAll()
        .antMatchers("/emp/**").hasAnyRole("USER")
        .antMatchers("/cust/**").access("hasRole('ADMIN')")
        .antMatchers("/student/**").hasAnyAuthority("READ_PRIVILEGE","UPDATE_PRIVILEGE")
        .antMatchers("/auth/**").hasAnyRole("ADMIN")
        .anyRequest().permitAll()
        .and().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler())
        .authenticationEntryPoint(getBasicAuthEntryPoint())
        .and()
        .formLogin()
        .loginPage("/auth_login")
        .loginProcessingUrl("/validate_auth")
        .permitAll()
        .and().rememberMe().key("newsecret").tokenValiditySeconds(15)
        //.rememberMe().rememberMeParameter("remember-me-new") for custom parameter name
        .and()
        .logout()
        //.logoutSuccessUrl("/auth_login?logout")(not needed default behaviour)
        .and()
        .httpBasic()
        .and()
        .sessionManagement()
        //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .maximumSessions(3).maxSessionsPreventsLogin(true).expiredUrl("/");
    }
    
//    In Memory Configuration
//     protected void configure(HttpSecurity http) throws Exception {
//            http
//            .csrf().disable()
//            .headers().frameOptions().sameOrigin()
//            .and().authorizeRequests()
//            //.antMatchers("/home","/emp/**").permitAll()                    
//            .antMatchers("/cust/**").access("hasRole('ADMIN')")
//            .antMatchers("/auth/**").access("hasRole('ADMIN')")
//            .anyRequest().permitAll()
//            .and().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler())
//            .authenticationEntryPoint(getBasicAuthEntryPoint())
//            .and()
//            .formLogin()
//                .loginPage("/auth_login")
//                .loginProcessingUrl("/validate_auth")
//                .permitAll()
//            .and()
//            .logout()
//            //.logoutSuccessUrl("/auth_login?logout")(not needed default behaviour)
//            .and()
//            .httpBasic()
//            .and()
//            .sessionManagement()
//                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .maximumSessions(3).maxSessionsPreventsLogin(true).expiredUrl("/");
//
//    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }

    @Bean
    public SecurityAcessDeniedHandler getAccessDeniedHandler() {
        return new SecurityAcessDeniedHandler();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
