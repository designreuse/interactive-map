package net.map.controller;

import net.map.domain.MapPoint;
import net.map.service.MapPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pingwin on 27.10.16.
 */
@Controller
public class PageController {
    private MapPointService mapPointService;

    @Autowired
    public PageController(MapPointService service){
        this.mapPointService = service;
    }

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    @RequestMapping("/admin/list")
    public String list(Model model) {
        model.addAttribute("points", mapPointService.list());
        return "admin/points/list";
    }

}
