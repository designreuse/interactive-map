package net.map.service;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MapPointService {
    private MapPointRepository mapPointRepository;

    @Autowired
    public MapPointService(MapPointRepository mapPointRepository){
        this.mapPointRepository = mapPointRepository;
    }

    public Iterable<MapPoint> list() {
        return mapPointRepository.findAll();
    }

    public MapPoint getById(long id) {
        return mapPointRepository.findOneById(id);
    }

    public MapPoint save(MapPoint point) {
        return mapPointRepository.save(point);
    }

    public void delete(MapPoint point) {
        mapPointRepository.delete(point);
    }

    public Iterable<MapPoint> getCategories(long id){ return mapPointRepository.findAllByCategoryId(id);}
    //public Iterable<Category> getByCategory(long id){ return mapPointRepository.findAllByCategoryId(id);}
}
