package com.tintuc.dunews.Service;

import com.tintuc.dunews.Entity.Article;
import com.tintuc.dunews.Entity.Category;
import com.tintuc.dunews.Entity.User;
import com.tintuc.dunews.Entity.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    User save(UserRegistration registrationDto);
    List<User> GetAllUser();
    void DeleteUser(Long id);
    void UpdateUser(User User);
}
