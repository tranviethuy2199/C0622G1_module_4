package com.example.model.Person.employee;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    private Integer id;
    private String name;

    @OneToOne(mappedBy = "position")
    private Position position;

    public Position() {
    }

    public Position(Integer id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
