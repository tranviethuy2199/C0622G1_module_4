package com.example.controller;

import com.example.model.Person.customer.Customer;
import com.example.model.Person.customer.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;


    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        List<CustomerType> customerTypes = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("customerTypes", customerTypes);
        modelAndView.addObject("customer" , customers);
       return modelAndView  ;}

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        List<CustomerType> customerTypes = customerTypeService.findAll();
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }
}
