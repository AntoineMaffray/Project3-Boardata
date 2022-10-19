package com.eql.project3.boardata.controller;

import com.eql.project3.boardata.models.User;
import com.eql.project3.boardata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String home () {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration (@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null && existingUser.getEmail() != null) {
            result.rejectValue("email", null, "Email already used");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/register";
        }
        user.setRegisterDate(LocalDate.now());
        userService.saveUser(user);
        return "redirect:/register?success";
    }



    @GetMapping("/connectedIndex")
    public String connectedIndex() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User connectedUser = userService.findUserByEmail(authentication.getName());
        if (connectedUser == null) {
            return "index";
        } else {
            return "connectedIndex";
        }
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/help")
    public String help () {
        return "help";
    }


}
