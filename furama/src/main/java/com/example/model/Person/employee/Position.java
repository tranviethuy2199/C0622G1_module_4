package com.example.model.Person.employee;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    private Integer position_Id;
    private String name;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "position_Id",referencedColumnName = "position_Id")
        private Employee employee;

    public Position() {
    }

    public Position(Integer position_Id, String name) {
        this.position_Id = position_Id;
        this.name = name;
    }

    public Integer getPosition_Id() {
        return position_Id;
    }

    public void setPosition_Id(Integer position_Id) {
        this.position_Id = position_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
