package com.example.repository;

import com.example.model.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloggerRepository extends JpaRepository<Blogger , Integer> {

}
