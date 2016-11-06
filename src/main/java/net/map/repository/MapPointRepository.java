package net.map.repository;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import org.springframework.data.repository.CrudRepository;


public interface MapPointRepository extends CrudRepository<MapPoint,Long>{

    public MapPoint findOneById(long id);
    public Iterable<MapPoint> findAllByCategoryId(long id);

}
