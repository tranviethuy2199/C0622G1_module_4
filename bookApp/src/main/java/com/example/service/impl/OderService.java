package com.example.service.impl;

import com.example.model.OderBook;
import com.example.repository.IOderRepository;
import com.example.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderService implements IOderService {
    @Autowired
    IOderRepository iOderRepository;
    @Override
    public List<OderBook> findAll() {
        return iOderRepository.findAll();
    }

    @Override
    public OderBook findById(int id) {
        return iOderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OderBook oderBook) {
        iOderRepository.save(oderBook);
    }
}
