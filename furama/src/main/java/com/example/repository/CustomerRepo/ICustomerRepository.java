package com.example.repository.CustomerRepo;

import com.example.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer , Integer> {
    @Query(value = "select * from Customer where name like %:keyword%", nativeQuery = true  )
    List<Customer> findCustomerByName(@Param("keyword") String customerName);

    @Query(value = "select * from Customer where customerType = customerType.id", nativeQuery = true)
    List<Customer> findCustomerByEmail(@Param("keyword") String customerEmail);

    @Query(value = "select * from Customer where email like %:keyword%", nativeQuery = true)
    List<Customer> findCustomerByCustomerType(@Param("keyword") String customerType);
}
