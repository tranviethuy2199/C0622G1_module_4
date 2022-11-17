package com.example.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer status = 1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id" , referencedColumnName = "id")
    private classRoom classRoom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academic_id" , referencedColumnName = "id")
    private Academic academic ;


    public Student() {
    }

    public Student(int id, String name, Integer status, com.example.model.classRoom classRoom, Academic academic) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.classRoom = classRoom;
        this.academic = academic;
    }

    public com.example.model.classRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(com.example.model.classRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Academic getAcademic() {
        return academic;
    }

    public void setAcademic(Academic academic) {
        this.academic = academic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public com.example.model.classRoom getaClass() {
        return classRoom;
    }

    public void setaClass(com.example.model.classRoom aClass) {
        this.classRoom = aClass;
    }
}
