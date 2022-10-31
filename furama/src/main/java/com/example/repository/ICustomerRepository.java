package com.example.repository;

import com.example.model.Person.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer , Integer> {
    @Query(value = "select * from Blogger where name like %:keyword%", nativeQuery = true)
    List<Customer> findCustomerByName(@Param("keyword") String CustomerName);
}
