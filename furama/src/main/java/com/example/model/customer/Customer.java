package com.example.model.customer;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private int idCard;
    private String phoneNumber;
    private String email;
    private int gender;
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id" , referencedColumnName = "id")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(Integer id, String name, Date dateOfBirth, int idCard,
                    String phoneNumber, String email, int gender, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
