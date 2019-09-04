/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.vo.Phone;
import com.funda.propertyeditors.PhoneNumberEditor;
import com.funda.vo.Student;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author phanic
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        dataBinder.registerCustomEditor(Phone.class, new PhoneNumberEditor());
    }

    @GetMapping(path = "/home")
    public String home(ModelMap model) {
        System.out.println("Hello Student");
        return "th_student_login";
    }

    @PostMapping(path = "/register")
    public String register(@Valid Student student, BindingResult result, ModelMap model) {
        try {
            System.out.println("age "+student.getAge());
            System.out.println("lastName "+student.getLastName());
            System.out.println(" phone "+student.getPhone());
            System.out.println("it has come here to register student ");
            if (result.hasErrors()) {
                System.out.println("there are errors");
            } else {
                System.out.println("error free registration");
            }
            model.addAttribute("msg", "successful registration");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "studentSuccessfulRegistration";
    }

}
