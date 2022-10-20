package com.example.service;

import com.example.model.Blogger;

import java.util.List;

public interface IBloggerService {

    List<Blogger> findAll();

//    Blogger findById(int id);

    void save(Blogger blogger);

    void remove(int id);
}
