package com.application.bank.controller;

import com.application.bank.entity.Admin;
import com.application.bank.entity.User;
import com.application.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserService userService;

    @GetMapping("/userlogin")
    public String userLogin(Model model) {
        return "userlogin";
    }
    @GetMapping("/userdashboard")
    public String userDashboard(@ModelAttribute("admin") Admin admin, Model model) {
        return "userdashboard";
    }

    @PostMapping("/userlogin")
    public String userlogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            RedirectAttributes redirectAttributes) {
        try {
            userService.userlogin(email,password);
            return "redirect:/userdashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Login failed: " + e.getMessage());
            return "redirect:/userlogin";
        }
    }

}
