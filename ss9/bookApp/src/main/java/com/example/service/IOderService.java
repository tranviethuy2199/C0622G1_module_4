package com.example.service;

import com.example.model.Book;
import com.example.model.OderBook;

import java.util.List;
import java.util.Optional;

public interface IOderService {
    List<OderBook> findAll();

    OderBook findById(int id);

    void save(OderBook oderBook);
}
