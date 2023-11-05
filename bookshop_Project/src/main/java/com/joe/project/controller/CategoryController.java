package com.joe.project.controller;

import com.joe.project.dto.CategoryDTO;
import com.joe.project.entity.Category;
import com.joe.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category_api")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> geCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCtg(@PathVariable("categoryId")Integer id){
        Optional<Category> category = categoryService.getById(id);
        return new CategoryDTO(category.get().getName());
    }

    @PostMapping("/category")
    public CategoryDTO addCtg(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return categoryDTO;
    }

}
