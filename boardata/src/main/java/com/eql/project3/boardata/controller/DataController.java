package com.eql.project3.boardata.controller;

import com.eql.project3.boardata.models.Final;
import com.eql.project3.boardata.models.Friendship;
import com.eql.project3.boardata.models.User;
import com.eql.project3.boardata.service.FriendshipService;
import com.eql.project3.boardata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    UserService userService;

    @Autowired
    FriendshipService friendshipService;



    @GetMapping("/myStats")
    public String myStats(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        // Appel du service
        List<Final> myData = userService.getFinalAllData(connectedUser);
        // Stockage
        model.addAttribute("myData", myData);
        if (myData.isEmpty()) {
            return "dontHaveScore";
        } else {
            return "myStats";
        }
    }

    @GetMapping("/friendsData")
    public String friendsData(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        // Appel du service
        List<User> myFriends = friendshipService.findMyFriends(connectedUser);
        // Stockage
        model.addAttribute("myFriends", myFriends);
        // Redirection vers page
        if (myFriends.isEmpty()) {
            return "dontHaveFriends";
        }
        return "friendsData";
    }

    @GetMapping("/friendData/{id}")
    public String friendData (@PathVariable(value = "id") Long idFriend, Model model) {
        User friend = userService.findUserByID(idFriend);
        List<Final> myData = userService.getFinalAllData(friend);
        // Stockage
        model.addAttribute("myData", myData);
        if (myData.isEmpty()) {
            return "dontHaveScore";
        } else {
            return "friendData";
        }
    }


}

