package com.example.service;

import com.example.model.classRoom;

import java.util.List;

public interface IClassService {
    List<classRoom> findAll();

    classRoom findById(int id);

    void save(classRoom aClass);

    void remove(classRoom aClass);
}
