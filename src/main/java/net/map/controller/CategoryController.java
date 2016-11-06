package net.map.controller;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import net.map.service.CategoryService;
import net.map.service.MapPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pingwin on 25.10.16.
 */
@RestController
public class CategoryController {
   // MapPointRepository mapPointRepository;
    MapPointService mapPointService;
    CategoryService categoryService;

    @Autowired
    public CategoryController(MapPointService mapPointService, CategoryService categoryService){
        this.mapPointService = mapPointService;
        this.categoryService = categoryService;
    }
/*
    @Autowired
    public CategoryController(MapPointRepository mapPointRepository){
        this.mapPointRepository = mapPointRepository;
    }
*/

    @CrossOrigin
    @RequestMapping("/categories")
    public Iterable<Category> list() {
        return categoryService.list();
    }

    // Get all map points for this category
    @CrossOrigin
    @RequestMapping("/categories/{id}")
    public Iterable<MapPoint> categoryById(@PathVariable(value="id") long id) { return mapPointService.getCategories(id); }



/*

    @RequestMapping("/get/{id}")
    public MapPoint getById(@PathVariable(value = "id") long id){
        return mapPointRepository.findOne(id);
    }

*/


}
