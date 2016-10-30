package net.map.service;

import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MapPointService {
    private MapPointRepository mapPointRepository;

    @Autowired
    public MapPointService(MapPointRepository repo){
        this.mapPointRepository = repo;
    }

    public Iterable<MapPoint> list() {
        return mapPointRepository.findAll();
    }
}
