package com.example.service;

import com.example.model.classRoom;
import com.example.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository classRepository;


    @Override
    public List<classRoom> findAll() {
        return classRepository.findAll();
    }

    @Override
    public classRoom findById(int id) {
        return null;
    }

    @Override
    public void save(classRoom aClass) {

    }

    @Override
    public void remove(classRoom aClass) {

    }
}
