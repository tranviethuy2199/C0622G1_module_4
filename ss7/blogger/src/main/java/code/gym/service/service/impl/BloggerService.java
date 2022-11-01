package code.gym.service.service.impl;

import code.gym.model.Blogger;
import code.gym.repository.IBloggerRepository;
import code.gym.service.service.IBloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BloggerService implements IBloggerService {

    @Autowired
    private IBloggerRepository bloggerRepository;

    @Override
    public List<Blogger> findAll() {
        return bloggerRepository.findAll();
    }

    @Override
    public Blogger findById(int id) {
        return bloggerRepository.findById(id).orElse(null);
        // nếu tìm thấy thì sẽ trả về một đối tượng , nếu không sẽ trả về null (orElse)
    }



    @Override
    public void save(Blogger blogger) {
        bloggerRepository.save(blogger);
    }

    @Override
    public void remove(Blogger blogger) {
        bloggerRepository.delete(blogger);
    }

    @Override
    public Page<Blogger> findAll(Pageable pageable) {
        return bloggerRepository.findAll(pageable);
    }

    @Override
    public List<Blogger> findBloggerByName(String BloggerName) {
        return bloggerRepository.findBloggerByName(BloggerName);
    }

    @Override
    public List<Blogger> findByName(String name) {
        return bloggerRepository.findByNameContains(name);
    }
}
