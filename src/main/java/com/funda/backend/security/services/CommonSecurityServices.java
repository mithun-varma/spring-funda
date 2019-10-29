/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security.services;

import com.funda.backend.exceptions.EmailExistsException;
import com.funda.backend.jpa.entities.Privilege;
import com.funda.backend.jpa.entities.Role;
import com.funda.backend.jpa.entities.User;
import com.funda.backend.jpa.repositories.PrivilegeRepository;
import com.funda.backend.jpa.repositories.RoleRepository;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.funda.backend.jpa.repositories.UserRepository;
import java.util.Optional;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
 *
 * @author phanic
 */
@Service
public class CommonSecurityServices implements
        ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DataSource appDataSource;

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("-- Context Refreshed --");
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(appDataSource);
//        execSql(jdbcTemplate, "SHOW TABLES");
//        execSql(jdbcTemplate, "Select * from USERS");
//        execSql(jdbcTemplate, "Select * from AUTHORITIES");

    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) {
            return;
        }
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("UPDATE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = new User();
        user.setUsername("admin");
        user.setFirstName("phani");
        user.setLastName("chekuri");
        user.setPassword(encoder.encode("ace2three"));
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        user.setEnabled(true);
        
        User user1 = new User();
        user1.setUsername("mith");
        user1.setFirstName("phani");
        user1.setLastName("chekuri");
        user1.setPassword(encoder.encode("ace2three"));
        user1.setEmail("mith@test.com");
        user1.setRoles(Arrays.asList(userRole));
        user1.setEnabled(true);
        
        userRepository.save(user);
        userRepository.save(user1);
        alreadySetup = true;
    }
    
    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
  
        Optional<Privilege> privOptional = privilegeRepository.findByName(name);
        Privilege privilege = privOptional.isPresent() ? privOptional.get() : null;
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    public static void execSql(JdbcTemplate jdbcTemplate, String sql) {
        System.out.printf("'%s'%n", sql);
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                System.out.println();
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metadata.getColumnName(i);
                    Object object = rs.getObject(i);
                    System.out.printf("%s = %s%n", columnName, object);
                }
            }
        });
        System.out.println("------------------");
    }
    
    public User registerNewUserAccount(User user) throws EmailExistsException {

        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: " + user.getEmail());
        }
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setUsername(user.getUsername());
        user.setFirstName( user.getFirstName());
        user.setLastName( user.getLastName());
        user.setEnabled(true);
        user.setPassword(encoder.encode( user.getPassword()));
        user.setEmail( user.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.save(user);
    }
    
    
    private boolean emailExist(String email){
        return userRepository.findByEmail(email).isPresent();
    }   
}
