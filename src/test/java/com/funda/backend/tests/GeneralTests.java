///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.funda.backend.tests;
//
//import com.funda.backend.DemoApplication;
//import com.funda.backend.controllers.HelloController;
//import com.funda.backend.controllers.ValidateParametersController;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
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
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {DemoApplication.class})
//public class GeneralTests {
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders
//        .standaloneSetup(new ValidateParametersController()).build();
//    }
//
//    @Test
//    public void givenMatchingEmailPassword_whenPostNewUserForm_thenOk()
//            throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//        .post("/validateRequestParameter")
//        .accept(MediaType.TEXT_HTML)
//        .param("param", "6"))
//        .andExpect(status().isOk());
//    }
//}
