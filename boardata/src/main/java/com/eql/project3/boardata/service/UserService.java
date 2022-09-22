package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.User;

import java.util.List;

public interface UserService {


    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}
