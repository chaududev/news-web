package com.tintuc.dunews.Service;

import com.tintuc.dunews.Entity.Category;

import java.util.List;
public interface ICategoryService {
    void AddCategory(Category Category);
    void UpdateCategory(Category Category);
    void DeleteCategory(Long id);
    List<Category> GetAllCategory();

}
