package com.example.service;

import com.example.model.Academic;
import com.example.repository.IAcademicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicService implements IAcademicService {
    @Autowired
    private IAcademicRepo academicRepo;
    @Override
    public List<Academic> findAll() {
        return academicRepo.findAll();
    }
}
