package net.map.repository;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category,Long>{

    public Category findOneById(long id);
    public Iterable<Category> findAll();
}
