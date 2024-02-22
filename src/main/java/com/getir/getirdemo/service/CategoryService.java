package com.getir.getirdemo.service;

import com.getir.getirdemo.model.Category;
import com.getir.getirdemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteOldCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category updateOldCategory(Long id, Category newCategory) {
        Category currentCategory = categoryRepository.getReferenceById(id);
        currentCategory.setName(newCategory.getName());
        currentCategory.setDescription(newCategory.getDescription());
        currentCategory.setImagePath(newCategory.getImagePath());
        return categoryRepository.save(currentCategory);
    }
}
