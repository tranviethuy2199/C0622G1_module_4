package code.gym.repository;

import code.gym.model.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBloggerRepository extends JpaRepository<Blogger, Integer> {

    @Query(value = "select * from Student where name =:keyword", nativeQuery = true)
    List<Blogger> findBloggerByName(@Param("keyword") String keyword);


}
