package com.example.service.impl;

import com.example.model.Person.customer.CustomerType;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeService.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeService.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeService.save(customerType);
    }

    @Override
    public void remove(CustomerType customerType) {
        customerTypeService.remove(customerType);
    }
}
