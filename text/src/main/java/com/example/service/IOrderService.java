package com.example.service;

import com.example.model.OrderProduct;

import java.util.List;

public interface IOrderService {
    List<OrderProduct> findAll();

    OrderProduct findById(int id);

    void save(OrderProduct orderProduct);

    void remove(OrderProduct orderProduct);
}
