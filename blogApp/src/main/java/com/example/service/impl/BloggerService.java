package com.example.service.impl;

import com.example.model.Blogger;
import com.example.repository.IBloggerRepository;
import com.example.service.IBloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

@Service
public class BloggerService implements IBloggerService {

    @Autowired
    private IBloggerRepository bloggerRepository;

    @Override
    public List<Blogger> findAll() {
        return bloggerRepository.findAll();
    }

//    @Override
//    public Blogger findById(int id) {
//        return bloggerRepository.findById(id);
//    }

    @Override
    public void save(Blogger blogger) {
        bloggerRepository.save(blogger);
    }

    @Override
    public void remove(int id) {
    }
}
