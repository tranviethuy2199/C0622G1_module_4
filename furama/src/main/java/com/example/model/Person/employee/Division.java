package com.example.model.Person.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Division {
    @Id
    private Integer division_Id;
    private String name;


}
