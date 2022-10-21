package code.gym.repository;

import code.gym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category , Integer> {
}
