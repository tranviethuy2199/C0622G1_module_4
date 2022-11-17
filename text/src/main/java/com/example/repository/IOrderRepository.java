package com.example.repository;

import com.example.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderProduct, Integer> {
}
