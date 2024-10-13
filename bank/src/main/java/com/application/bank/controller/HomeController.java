package com.application.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("api/bank")
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

}
