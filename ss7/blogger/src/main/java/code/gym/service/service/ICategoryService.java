package code.gym.service.service;

import code.gym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(Category category);
}
