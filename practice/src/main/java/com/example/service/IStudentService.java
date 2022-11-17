package com.example.service;

import com.example.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);

    List<Student> findAll();

    Student findById(Integer id);

    // lưu khi add customer
    void save(Student student);

    // xóa customer
    void remove(Student student);

}
