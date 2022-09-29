//package com.eql.project3.boardata.controller;
//
//import com.eql.project3.boardata.models.Game;
//import com.eql.project3.boardata.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class FriendshipController {
//
//    UserService userService;
//
//    @GetMapping("/chooseGame")
//    public String showGames(Model model) {
//        // Appel du service
//        List<Game> games = userService.findMyFriends();
//        // Stockage
//        model.addAttribute("games", games);
//        // Redirection vers page
//        return "chooseGame";
//    }
//}
