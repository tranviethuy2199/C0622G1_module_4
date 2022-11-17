package com.example.repository;

import com.example.model.Academic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAcademicRepo extends JpaRepository<Academic , Integer> {
}
