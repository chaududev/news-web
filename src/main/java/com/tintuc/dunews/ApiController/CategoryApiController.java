package com.tintuc.dunews.ApiController;

import com.tintuc.dunews.Entity.Category;
import com.tintuc.dunews.Service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController

@RequestMapping(value = {"/api/category"})
public class CategoryApiController {

    @Autowired
    ICategoryService service;
    @GetMapping
    public ResponseEntity<?> getCategorys(){
        List<Category> Categorys=service.GetAllCategory();
        return ResponseEntity.ok(Categorys);
    }
    @PostMapping(value = {"/add"})
    public ResponseEntity<?>AddCategory(@RequestBody Category Category){
        service.AddCategory(Category);
        return ResponseEntity.ok("Add Success!!!");
    }
    @PutMapping(value = {"/update"})
    public ResponseEntity<?>UpdateCategory(@RequestBody Category Category){
        service.UpdateCategory(Category);
        return ResponseEntity.ok("Update Success!!!");
    }
    @DeleteMapping (value = {"/delete"})
    public ResponseEntity<?>DeleteCategory(@RequestParam Long id){
        service.DeleteCategory(id);
        return ResponseEntity.ok("Delete Success!!!");
    }
}

