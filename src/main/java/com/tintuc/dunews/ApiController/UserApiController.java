package com.tintuc.dunews.ApiController;

import com.tintuc.dunews.Entity.Category;
import com.tintuc.dunews.Entity.User;
import com.tintuc.dunews.Service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController

@RequestMapping(value = {"/api/user"})
public class UserApiController {

    @Autowired
    IUserService service;
    @GetMapping
    public ResponseEntity<?> getUsers(){
        List<User> Users=service.GetAllUser();
        return ResponseEntity.ok(Users);
    }
    @DeleteMapping (value = {"/delete"})
    public ResponseEntity<?>DeleteUser(@RequestParam Long id){
        service.DeleteUser(id);
        return ResponseEntity.ok("Delete Success!!!");
    }
    @PutMapping(value = {"/update"})
    public ResponseEntity<?>UpdateUser(@RequestBody User user){
        service.UpdateUser(user);
        return ResponseEntity.ok("Update Success!!!");
    }
}

