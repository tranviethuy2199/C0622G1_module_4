package com.example.controller;

import com.example.model.Person.customer.Customer;
import com.example.service.ICustomerService;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {

    @Autowired
    ICustomerService customerService;


    @GetMapping("/furamas")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        List<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("customer" , customers);
       return null  ;  }
}
