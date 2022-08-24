package com.tintuc.dunews.Service.imp;
import com.tintuc.dunews.Entity.Category;
import com.tintuc.dunews.Repository.ICategoryRepository;
import com.tintuc.dunews.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository repository;

    @Override
    public void AddCategory(Category Category) {
        try{
            repository.save(Category);
        }catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public void UpdateCategory(Category Category){
        try{
            repository
                    .findById(Category.getId()) // returns Optional<User>
                    .ifPresent(Category1 -> {
                        Category1.setCreateDate(Category.getCreateDate());
                        Category1.setUpdateDate(Category.getUpdateDate());
                        Category1.setIdCreateUser(Category.getIdCreateUser());
                        Category1.setCategoryKey(Category.getCategoryKey());
                        Category1.setCategoryName(Category.getCategoryName());
                        repository.save(Category1);
                    });

        } catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public void DeleteCategory(Long id) {
        try{
            // repository.deleteById(id);
            boolean isExits =repository.findById(id).isPresent();
            if(isExits){
                repository.deleteById(id);
            }else {
                // throw new Exception("Category not exits!!!");
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public List<Category> GetAllCategory() {
        List<Category>Categorys= repository.findAll();
        return Categorys;
    }


}

