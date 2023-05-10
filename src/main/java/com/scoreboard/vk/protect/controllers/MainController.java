package com.scoreboard.vk.protect.controllers;

import com.scoreboard.vk.protect.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/")
    public String getHome(@AuthenticationPrincipal UserDetails userDetails, Model model){
        model.addAttribute("userRatings", userService.getProgress(userDetails.getUsername()));
        return "home";
    }
    @GetMapping(value = "/admin")
    public String getAdminPanel(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }
}
