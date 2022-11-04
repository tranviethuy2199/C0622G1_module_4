package com.example.model.facility;

import javax.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double area;
    private double cost;
    private int amount;
    private String convenience; // tiện nghi - room and villa
    private int floors;
    private String facility_free; // dịch vụ miễn phí đi kèm - room
    private double pool_area; // diện tích hồ bơi - villa


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="standardRoom_id" , referencedColumnName = "id")
    private StandardRoom standardRoom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rentType_id" , referencedColumnName = "id")
    private RentType rentType;

    public Facility() {
    }

    public Facility(Integer id, String name, double area, double cost,
                    int amount, String convenience, int floors, String facility_free,
                    double pool_area, StandardRoom standardRoom, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.amount = amount;
        this.convenience = convenience;
        this.floors = floors;
        this.facility_free = facility_free;
        this.pool_area = pool_area;
        this.standardRoom = standardRoom;
        this.rentType = rentType;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public StandardRoom getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(StandardRoom standardRoom) {
        this.standardRoom = standardRoom;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
