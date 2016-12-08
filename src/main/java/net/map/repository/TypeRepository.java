package net.map.repository;

import net.map.domain.Category;
import net.map.domain.Type;
import org.springframework.data.repository.CrudRepository;


public interface TypeRepository extends CrudRepository<Type,Long>{

    public Type findOneById(long id);
    public Iterable<Type> findAll();
}
