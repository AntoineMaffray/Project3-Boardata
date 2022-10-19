package com.eql.project3.boardata.service;

import com.eql.project3.boardata.models.Final;
import com.eql.project3.boardata.models.Game;
import com.eql.project3.boardata.models.User;

import java.util.List;

public interface UserService {


    void saveUser(User user);

    User findUserByEmail(String email);

    User findUserByID (Long id);

    List<User> findAllUsers();

    List<User> findMyFriends();

    List<Final> getData(User user);

    List<Final> getAllData(User user);

    List<Final> getFinalAllData(User user);
}


