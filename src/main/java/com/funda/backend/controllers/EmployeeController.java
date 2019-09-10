/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.controllers;

import com.funda.backend.vo.Employee;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author phanic
 */
@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    private Map<Integer, Employee> emps = null;
    
    
    @Autowired
    @Qualifier("employeeValidator")        
    Validator validator;
    
    @InitBinder("employee")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
        //binder.registerCustomEditor(Phone.class, new PhoneNumberEditor());
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public EmployeeController() {
        emps = new HashMap<>();
    }

    @ModelAttribute("employee")
    public Employee createEmployeeModel() {
        // ModelAttribute value should be same as used in the empSave.jsp
        return new Employee();
    }

    @RequestMapping(value = "/emp/save", method = RequestMethod.GET)
    public String saveEmployeePage(Model model) {
        logger.info("Returning empSave.jsp page");
        return "empSave";
    }

    @RequestMapping(value = "/emp/save.do", method = RequestMethod.POST)
    public String saveEmployeeAction(
            @ModelAttribute("employee") @Validated Employee employee,
            BindingResult bindingResult, Model model) {
        System.out.println("emp doj is "+employee.getDoj());
        System.out.println("emp phone is "+employee.getPhone());
        if (bindingResult.hasErrors()) {
            logger.info("Returning empSave.jsp page");
            return "empSave";
        }
        logger.info("Returning empSaveSuccess.jsp page");
        model.addAttribute("emp", employee);
        emps.put(employee.getId(), employee);
        return "empSaveSuccess";
    }
}
