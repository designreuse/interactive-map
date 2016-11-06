package net.map.controller;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;
import net.map.service.CategoryService;
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
    private CategoryService categoryService;
    @Autowired
    public PageController(MapPointService mapPointService, CategoryService categoryService){
        this.mapPointService = mapPointService;
        this.categoryService = categoryService;
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
        model.addAttribute("categories", categoryService.list());
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

    // Categories
    @RequestMapping("/admin/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.list());
        return "admin/categories/list";
    }

    @RequestMapping("/admin/categories/{id}")
    public String listCategories(@PathVariable(value="id") Long id, Model model) {
        model.addAttribute("points", mapPointService.getCategories(id));
        return "admin/categories/pointsList";
    }


    @RequestMapping("/admin/categories/view/{id}")
    public String viewCategory(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("category", categoryService.findOne(id));
        return "admin/categories/view";
    }

    @RequestMapping("/admin/categories/edit/{id}")
    public String editCategory(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("category", categoryService.findOne(id));
        model.addAttribute("categories", categoryService.list());
        return "admin/categories/categoryForm";
    }

    @RequestMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable(value="id") Long id){
        Category category = categoryService.findOne(id);
        categoryService.delete(category);
        return "redirect:/admin/categories";
    }

    @RequestMapping("admin/categories/create")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "admin/categories/categoryForm";
    }

    @RequestMapping(value="admin/categories/save", method= RequestMethod.POST)
    public String saveCategory(@Valid Category category, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("category", categoryService.list());
            return "admin/categories/categoryForm";
        }else{
            categoryService.save(category);
            return "redirect:/admin/categories/view/" + category.getId();
        }
    }





    // Trash below
    @RequestMapping("/testcluster")
    public String testcluster(Model model) {
        return "testcluster";
    }


}
