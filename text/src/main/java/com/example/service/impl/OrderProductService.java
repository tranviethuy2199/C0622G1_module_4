package com.example.service.impl;

import com.example.model.OrderProduct;
import com.example.repository.IOrderRepository;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;


    @Override
    public List<OrderProduct> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderProduct findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OrderProduct orderProduct) {
        orderRepository.save(orderProduct);
    }

    @Override
    public void remove(OrderProduct orderProduct) {
        orderRepository.delete(orderProduct);
    }
}
