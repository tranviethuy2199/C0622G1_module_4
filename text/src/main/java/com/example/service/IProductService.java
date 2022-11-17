package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Integer id);

    void save(Product product);

    void remove(Product product);

    Page<Product> findAll(Pageable pageable);



}
