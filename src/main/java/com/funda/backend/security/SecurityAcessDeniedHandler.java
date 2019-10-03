/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.funda.backend.vo.ResponseDTO;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 *
 * @author phanic
 */
public class SecurityAcessDeniedHandler implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest hsr, HttpServletResponse hsres, AccessDeniedException ade) throws IOException, ServletException {
       
        Authentication auth 
          = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println("User: " + auth.getName() 
              + " attempted to access the protected URL: "
              + hsr.getRequestURI()+" hsr context path "+hsr.getContextPath());
        }
 
        hsres.sendRedirect(hsr.getContextPath() + "/accessDenied");
        
        //Restful Way
        /*ResponseDTO response = new ResponseDTO();
        response.setStatus("403");
        response.setMessage("Access Denied");
        OutputStream out = hsres.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, response);
        out.flush();*/
    }
    
}
