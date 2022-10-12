package com.boats.repository;

import com.boats.model.CategoryModel;
import com.boats.repository.crudrepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryCrudRepository.save(categoryModel);
    }

    public void deleteCategory(Integer id) {
        categoryCrudRepository.deleteById(id);
    }
}
