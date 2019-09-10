/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.vo.Customer;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phanic
 */
@Controller
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    private Map<String, Customer> customers = null;

    public CustomerController() {
        customers = new HashMap<>();
    }

    @RequestMapping(value = "/cust/save", method = RequestMethod.GET)
    public String saveCustomerPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "custSave";
    }

    @RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
    public String saveCustomerAction(
            @Valid Customer customer,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "custSave";
        }
        model.addAttribute("customer", customer);
        customers.put(customer.getEmail(), customer);
        return "custSaveSuccess";
    }

    @RequestMapping(value = "/customer/signup", method = RequestMethod.POST)
    public String addCustomer(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "signUpForm";
        } else {
            return "Done";
        }

    }

    @RequestMapping(value = "/customer/singupView", method = RequestMethod.GET)
    public String displayCustomerForm(ModelMap model) {

        model.addAttribute("customer", new Customer());
        return "signUpForm";

    }

}
