package com.example.repository;

import com.example.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderRepository extends JpaRepository<OderBook,Integer> {
}
