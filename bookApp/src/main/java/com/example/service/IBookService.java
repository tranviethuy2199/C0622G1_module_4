package com.example.service;

import com.example.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<Book> findAll();

    Book findById(int id);

    void save(Book book);
}
