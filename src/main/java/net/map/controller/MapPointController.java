package net.map.controller;

import com.monitorjbl.json.JsonResult;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.Match;
import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pingwin on 25.10.16.
 */
@RestController
public class MapPointController {
    MapPointRepository mapPointRepository;
    private JsonResult json = JsonResult.instance();


    @Autowired
    public MapPointController(MapPointRepository mapPointRepository){
        this.mapPointRepository = mapPointRepository;
    }

    @CrossOrigin
    @RequestMapping("/get")
    public Iterable<MapPoint> list() {
        return mapPointRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping("/get/{id}")
    public void getById(@PathVariable(value = "id") long id){
        MapPoint point =  mapPointRepository.findOne(id);
        json.use(JsonView.with(point)
                .onClass(MapPoint.class, Match.match()
                        .exclude("category")));
    }



}
