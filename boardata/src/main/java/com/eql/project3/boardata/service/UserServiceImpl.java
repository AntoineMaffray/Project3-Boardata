package com.eql.project3.boardata.service;


import com.eql.project3.boardata.models.Role;
import com.eql.project3.boardata.models.User;
import com.eql.project3.boardata.repository.RoleRepository;
import com.eql.project3.boardata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");

        if (role == null) {
            role = checkRoleExist();
        }

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {

        return  userRepository.findAll();
//
//        List<User> users = userRepository.findAll();
//
//        return users.stream().collect(Collectors.toList());

//        return new ArrayList<>(users);
    }

}

