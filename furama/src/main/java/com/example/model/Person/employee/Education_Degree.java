package com.example.model.Person.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Education_Degree {
    @Id
    private Integer education_degree_Id;
    private String name;

    public Education_Degree() {
    }

    public Education_Degree(Integer education_degree_Id, String name) {
        this.education_degree_Id = education_degree_Id;
        this.name = name;
    }

    public Integer getEducation_degree_Id() {
        return education_degree_Id;
    }

    public void setEducation_degree_Id(Integer education_degree_Id) {
        this.education_degree_Id = education_degree_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
