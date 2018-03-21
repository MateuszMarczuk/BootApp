package com.marczuk.services;

import com.marczuk.entity.Role;
import com.marczuk.entity.User;
import com.marczuk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 11.03.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }


    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public boolean isUserPresent(String email) {
        User user = userRepository.findOneByEmail(email);
        if (user != null ){
            return true;
        } return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%"+name+"%");
    }


}
