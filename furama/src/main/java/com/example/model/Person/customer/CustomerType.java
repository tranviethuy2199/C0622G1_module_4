package com.example.model.Person.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerType{
    @Id
    private Integer customerTypeId;
    private String name;

}
