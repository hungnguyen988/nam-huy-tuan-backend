package com.example.namhuytuan.service.category;

import com.example.namhuytuan.model.category.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category newCategory);
    void deleteCategory(Long id);
}
