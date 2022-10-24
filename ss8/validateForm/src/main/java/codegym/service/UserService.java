package codegym.service;

import codegym.model.User;
import codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
