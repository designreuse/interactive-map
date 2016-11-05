package net.map.controller;

import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import net.map.service.MapPointService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping("/getPlace/{id}")
    public String getPlace(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("point", mapPointService.getById(id));
        return "views/getPlace";
    }

    @RequestMapping("/admin/list")
    public String list(Model model) {
        model.addAttribute("points", mapPointService.list());
        return "admin/points/list";
    }


    @RequestMapping("/admin/list/view/{id}")
    public String view(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("point", mapPointService.getById(id));
        return "admin/points/view";
    }

    @RequestMapping("/admin/list/edit/{id}")
    public String edit(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("point", mapPointService.getById(id));
        return "admin/points/pointForm";
    }

    @RequestMapping("/admin/list/delete/{id}")
    public String delete(@PathVariable(value="id") Long id, Model model){
        MapPoint point = mapPointService.getById(id);
        mapPointService.delete(point);
        return "redirect:/admin/list";
    }

   /* @RequestMapping(value="admin/list/update", method= RequestMethod.POST)
    public String update(MapPoint mapPoint){
        mapPointService.save(mapPoint);
        return "redirect:/admin/list/view/" + mapPoint.getId();
    }*/

    @RequestMapping("admin/list/create")
    public String create(Model model){
        model.addAttribute("point", new MapPoint());
        return "admin/points/pointForm";
    }

    @RequestMapping(value="admin/list/save", method= RequestMethod.POST)
    public String save(@Valid MapPoint mapPoint, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("point", mapPointService.list());
            return "admin/points/pointForm";
        }else{
            mapPointService.save(mapPoint);
            return "redirect:/admin/list/view/" + mapPoint.getId();
        }
    }


    @RequestMapping("/testcluster")
    public String testcluster(Model model) {
        return "testcluster";
    }


}
