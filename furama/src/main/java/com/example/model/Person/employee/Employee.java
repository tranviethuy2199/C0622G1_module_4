package com.example.model.Person.employee;

import com.example.model.Person.Person;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class Employee extends Person {
    private double salary;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Position position;

    @OneToOne
    @JoinColumn(name = "education_degree" , referencedColumnName = "id")
    private Education_Degree educationDegree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_Id", referencedColumnName = "position_Id")
    private Employee employee;


    public Employee(){};

    public Employee(int id, String name, Date dayOfBirth, int idCard,
                    String phoneNumber, String email, double salary, Position position,
                    Education_Degree educationDegree, Employee employee) {
        super(id, name, dayOfBirth, idCard, phoneNumber, email);
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.employee = employee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
