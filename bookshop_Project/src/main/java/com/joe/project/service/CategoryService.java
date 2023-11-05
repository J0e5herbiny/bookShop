package com.joe.project.service;

import com.joe.project.dto.CategoryDTO;
import com.joe.project.entity.Category;
import com.joe.project.reposietpry.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

  //  @Override
    public List<Category> getAll(){             // Read
        return categoryRepository.findAll();
    }

    public Optional<Category> getById (int id){  // Read by id
        return categoryRepository.findById(id);
    }

    public void save(CategoryDTO categoryDTO){    // Create, Update
        Category category = new Category(categoryDTO.getName());
        category.setId(0);
        categoryRepository.save(category);
    }

    public String delete(int id){           // Deleted
        categoryRepository.deleteById(id);
        return "Deleted";
    }


}
