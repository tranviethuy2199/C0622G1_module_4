package com.example.service;

import com.example.model.OrderProduct;
import com.example.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();

    ProductType findById(int id);

    void save(ProductType productType);

    void remove(ProductType productType);
}
