package com.example.repository;


import com.example.model.classRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<classRoom, Integer> {
}
