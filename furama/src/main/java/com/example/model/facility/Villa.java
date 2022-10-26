package com.example.model.facility;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Villa extends Facility{
    private Integer standard_room;
    private String description_other_convenience;
    private double pool_area;
    private int number_of_floors;

    public Villa() {
    }

    public Villa(Integer id, String name, int area, double cost, int max_people, Integer rent_type_Id, Integer facility_type_Id,
                 Integer standard_room, String description_other_convenience, double pool_area, int number_of_floors) {
        super(id, name, area, cost, max_people, rent_type_Id, facility_type_Id);
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public Integer getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(Integer standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
