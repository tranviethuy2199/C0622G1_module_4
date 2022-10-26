package com.example.model.Person.employee;

import com.example.model.Person.Person;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;

public class Employee extends Person {
    private Integer educationDegree_Id;
    private Integer position_Id;
    private double salary;

    @OneToOne(mappedBy = "position_Id")
    private Position position;
    public Employee() {
    }

    public Employee(int id, String name, Date dayOfBirth, int idCard, String phoneNumber,
                    String email, Integer educationDegree_Id, Integer position_Id, double salary) {
        super(id, name, dayOfBirth, idCard, phoneNumber, email);
        this.educationDegree_Id = educationDegree_Id;
        this.position_Id = position_Id;
        this.salary = salary;
    }

    public Integer getEducationDegree_Id() {
        return educationDegree_Id;
    }

    public void setEducationDegree_Id(Integer educationDegree_Id) {
        this.educationDegree_Id = educationDegree_Id;
    }

    public Integer getPosition_Id() {
        return position_Id;
    }

    public void setPosition_Id(Integer position_Id) {
        this.position_Id = position_Id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
