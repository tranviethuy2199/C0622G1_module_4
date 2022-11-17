package com.example.service.impl;

import com.example.model.ProductType;
import com.example.repository.IProductRepository;
import com.example.repository.IProductTypeRepository;
import com.example.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;


    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(int id) {
        return productTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void remove(ProductType productType) {
        productTypeRepository.delete(productType);
    }
}
