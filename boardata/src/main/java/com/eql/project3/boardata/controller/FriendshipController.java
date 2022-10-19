package com.eql.project3.boardata.controller;

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


import java.time.LocalDate;
import java.util.List;

@Controller
public class FriendshipController {

    @Autowired
    FriendshipService friendshipService;

    @Autowired
    UserService userService;

    Friendship thisFriendship;


    @GetMapping("/friends")
    public String friends(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        // Appel du service
        List<User> myFriends = friendshipService.findMyFriends(connectedUser);
        myFriends.remove(connectedUser);
        // Stockage
        model.addAttribute("myFriends", myFriends);
        // Redirection vers page
        if (myFriends.isEmpty()) {
            return "dontHaveFriends";
        }
        return "friends";
    }

    @GetMapping("/addFriends")
    public String addFriends(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        // Appel du service
        List<User> notMyFriends = userService.findAllUsers();
        List<User> myFriends = friendshipService.findMyFriends(connectedUser);
        List<User> myPendingFriends = friendshipService.findMyPendingFriends(connectedUser);
        List<User> myAskedFriends = friendshipService.askedFriends(connectedUser);
        for (User myFriend : myFriends) {
            notMyFriends.remove(myFriend);
        }
        for (User myPendingFriend : myPendingFriends) {
            notMyFriends.remove(myPendingFriend);
        }
        for (User myAskedFriend : myAskedFriends) {
            notMyFriends.remove(myAskedFriend);
        }
        notMyFriends.remove(connectedUser);
        // Stockage
        model.addAttribute("notMyFriends", notMyFriends);
        // Redirection vers page
        return "addFriends";
    }


    @PostMapping("/addFriend/{id}")
    public String addFriend (@PathVariable(value = "id") Long idFriend) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        Friendship friendship = new Friendship();
        friendship.setFriend(userService.findUserByID(idFriend));
        friendship.setRequester(connectedUser);
        friendshipService.saveFriendship(friendship);
        return "redirect:/addFriends?success";
    }

    @GetMapping("/pendingFriends")
    public String pendingFriends(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        System.out.println(connectedUser.getFirstname() + connectedUser.getName());
        // Appel du service
        List<User> myPendingFriends = friendshipService.findMyPendingFriends(connectedUser);
        // Stockage
        model.addAttribute("myPendingFriends", myPendingFriends);
        // Redirection vers page
        return "pendingFriends";
    }

    @GetMapping("/askedFriends")
    public String askedFriends(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        // Appel du service
        List<User> myAskedFriends = friendshipService.askedFriends(connectedUser);
        // Stockage
        model.addAttribute("myAskedFriends", myAskedFriends);
        // Redirection vers page
        return "askedFriends";
    }

    @PostMapping("/acceptFriend/{id}")
    public String acceptFriend (@PathVariable(value = "id") Long idFriend) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        thisFriendship = friendshipService.findFrienshipByIds(userService.findUserByID(idFriend), connectedUser);
        thisFriendship.setActive(true);
        thisFriendship.setDate(LocalDate.now());
        friendshipService.saveFriendship(thisFriendship);
        return "redirect:/askedFriends?success";
    }



}




