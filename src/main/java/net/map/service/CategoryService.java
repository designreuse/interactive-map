package net.map.service;

import net.map.domain.Category;
import net.map.domain.MapPoint;
import net.map.repository.CategoryRepository;
import net.map.repository.MapPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> list() {
        return categoryRepository.findAll();
    }

    public Category findOne(long id) {
        return categoryRepository.findOneById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
