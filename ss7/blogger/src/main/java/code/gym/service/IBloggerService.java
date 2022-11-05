package code.gym.service;

import code.gym.model.Blogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBloggerService {

    List<Blogger> findAll();

    Blogger findById(int id);

    void save(Blogger blogger);

    void remove(Blogger blogger);

    Page<Blogger> findAll(Pageable pageable);

    List<Blogger> findBloggerByName(String bloggerName , Pageable pageable);

    List<Blogger> findByName(String name);
}
