package com.example.dto;

import com.example.model.Academic;
import com.example.model.classRoom;

public class StudentDto {
    private int id;
    private String name;
    private classRoom classRoom;
    private Academic academic ;

    public StudentDto() {
    }

    public StudentDto(int id, String name, com.example.model.classRoom classRoom, Academic academic) {
        this.id = id;
        this.name = name;
        this.classRoom = classRoom;
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
}
