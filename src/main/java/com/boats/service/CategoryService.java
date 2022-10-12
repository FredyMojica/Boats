package com.boats.service;

import com.boats.model.CategoryModel;
import com.boats.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategories(){
        return categoryRepository.getAllCategories();
    }

    public Optional<CategoryModel> getCategory(Integer id){
        return categoryRepository.getCategory(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel){
        if (categoryModel.getId()==null){
            return categoryRepository.saveCategory(categoryModel);
        }else{
            Optional<CategoryModel> optionalCategoryModel=categoryRepository.getCategory(categoryModel.getId());
            if (optionalCategoryModel.isEmpty()){
                return categoryRepository.saveCategory(categoryModel);
            }else {
                return categoryModel;
            }
        }
    }

    public CategoryModel updateCategory(CategoryModel categoryModel){
        if (categoryModel.getId()!=null){
            Optional<CategoryModel> optionalCategoryModel=categoryRepository.getCategory(categoryModel.getId());
            if (!optionalCategoryModel.isEmpty()){
                if (categoryModel.getName()!=null){
                    optionalCategoryModel.get().setName(categoryModel.getName());
                }
                if (categoryModel.getDescription()!=null){
                    optionalCategoryModel.get().setDescription(categoryModel.getDescription());
                }
                categoryRepository.saveCategory(optionalCategoryModel.get());
                return  optionalCategoryModel.get();
            }else {
                return categoryModel;
            }
        }else {
            return categoryModel;
        }
    }

    public boolean deleteCategory(Integer id){
        Boolean aBoolean=getCategory(id).map(categoryModel -> {
            categoryRepository.deleteCategory(categoryModel);
            return  true;
        }).orElse(false);
        return aBoolean;
    }

}
