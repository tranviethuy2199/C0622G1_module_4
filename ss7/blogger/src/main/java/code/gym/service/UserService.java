package code.gym.service;

import code.gym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);
}
