package com.example.model.Person.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Education_Degree {
    @Id
    private Integer id;
    private String name;

    @OneToOne(mappedBy = "education_degree")
    private Employee employee;

    public Education_Degree() {
    }

    public Education_Degree(Integer id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
