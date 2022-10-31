package com.example.repository;

import com.example.model.Person.customer.Customer;
import com.example.model.Person.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee , Integer> {
    @Query(value = "select * from Blogger where name like %:keyword%", nativeQuery = true)
    List<Employee> findEmployeeByName(@Param("keyword") String employeeName);
}
