package com.example.model.facility;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Facility {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int area;
    private double cost;
    private int max_people;
    private Integer rent_type_Id;
    private Integer facility_type_Id;

    public Facility() {
    }

    public Facility(Integer id, String name, int area, double cost,
                    int max_people, Integer rent_type_Id, Integer facility_type_Id) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.rent_type_Id = rent_type_Id;
        this.facility_type_Id = facility_type_Id;
    }
}
