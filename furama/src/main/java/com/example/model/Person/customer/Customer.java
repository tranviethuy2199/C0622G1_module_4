package com.example.model.Person.customer;

import com.example.model.Person.Person;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Customer extends Person {
    private String gender;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id" , referencedColumnName = "id")
    private CustomerType customerType;


    public Customer() {
    }

    public Customer(int id, String name, Date dayOfBirth, int idCard, String phoneNumber,
                    String email, String gender, String address, CustomerType customerType) {
        super(id, name, dayOfBirth, idCard, phoneNumber, email);
        this.gender = gender;
        this.address = address;
        this.customerType = customerType;
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

}
