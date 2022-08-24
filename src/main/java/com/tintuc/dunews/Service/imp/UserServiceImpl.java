package com.tintuc.dunews.Service.imp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.tintuc.dunews.Entity.Article;
import com.tintuc.dunews.Entity.Role;
import com.tintuc.dunews.Entity.User;
import com.tintuc.dunews.Entity.UserRegistration;
import com.tintuc.dunews.Repository.IRoleRepository;
import com.tintuc.dunews.Repository.IUserRepository;
import com.tintuc.dunews.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    private final IRoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository, IRoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserRegistration registrationDto) {
        List<Role> roles
                  = roleRepository.findAllByName("ROLE_USER");

        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()) , roles);
        return userRepository.save(user);
    }

    @Override
    public List<User> GetAllUser() {
        List<User> Users = userRepository.findAll();
        return Users;
    }

    @Override
    public void DeleteUser(Long id) {
        try{
            // repository.deleteById(id);
            boolean isExits =userRepository.findById(id).isPresent();
            if(isExits){
                userRepository.deleteById(id);
            }else {
                // throw new Exception("Article not exits!!!");
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public void UpdateUser(User User) {
        try{
            userRepository.findById(User.getId())
                    .ifPresent(User1 -> {
                        User1.setEmail(User.getEmail());
                        User1.setFirsName(User.getFirsName());
                        User1.setLastName(User.getLastName());
                        User1.setPassword(passwordEncoder.encode(User.getPassword()));
                        User1.setRoles(User.getRoles());
                        userRepository.save(User1);
                    });
        }
        catch (Exception ex){
            throw ex;
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password![1]");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}