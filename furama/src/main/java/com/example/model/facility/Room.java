package com.example.model.facility;

public class Room extends Facility{
    private String facility_free;

    public Room() {
    }

    public Room(Integer id, String name, int area,
                double cost, int max_people, Integer rent_type_Id, Integer facility_type_Id, String facility_free) {
        super(id, name, area, cost, max_people, rent_type_Id, facility_type_Id);
        this.facility_free = facility_free;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }
}
