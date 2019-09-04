///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.tests;
//
//import com.funda.backend.controllers.HelloController;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
///**
// *
// * @author phanic
// */
//public class ClassLevelAnnotationTest {
//    private MockMvc mockMvc;
//     
//    @Before
//    public void setup(){
//        this.mockMvc = MockMvcBuilders
//          .standaloneSetup(new HelloController()).build();
//    }
//     
//    @Test
//    public void givenMatchingEmailPassword_whenPostNewUserForm_thenOk() 
//      throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//        .post("/formSubmit")
//        .accept(MediaType.TEXT_HTML)
//        .param("email", "john@yahoo.com")
//        .param("verifyEmail", "joh@yahoo.com")
//        .param("password", "pass")
//        .param("verifyPassword", "pas"))
//        .andExpect(model().errorCount(2))
//        .andExpect(status().isOk());
//    }
//}
