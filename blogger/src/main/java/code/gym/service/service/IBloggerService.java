package code.gym.service.service;

import code.gym.model.Blogger;
import java.util.List;

public interface IBloggerService {

    List<Blogger> findAll();

    Blogger findById(int id);

    void save(Blogger blogger);

    void remove(Blogger blogger);

    List<Blogger> findBloggerByName(String BloggerName);
}
