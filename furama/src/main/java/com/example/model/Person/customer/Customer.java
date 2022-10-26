package com.example.model.Person.customer;

import com.example.model.Person.Person;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Customer extends Person {
    private Integer customerTypeId;
    private String gender;
    private String address;
    private Integer customerType_Id;

    public Customer() {
    }

    public Customer(int id, String name, Date dayOfBirth, int idCard, String phoneNumber, String email,
                    Integer customerTypeId, String gender, String address, Integer customerType_Id) {
        super(id, name, dayOfBirth, idCard, phoneNumber, email);
        this.customerTypeId = customerTypeId;
        this.gender = gender;
        this.address = address;
        this.customerType_Id = customerType_Id;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCustomerType_Id() {
        return customerType_Id;
    }

    public void setCustomerType_Id(Integer customerType_Id) {
        this.customerType_Id = customerType_Id;
    }
}
