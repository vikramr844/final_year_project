package com.application.bank.controller;

import com.application.bank.entity.Admin;
import com.application.bank.repo.UserRepository;
import com.application.bank.service.AdminService;
import com.application.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // Admin login page (GET method)
    @GetMapping("/adminlogin")
    public String adminLoginPage() {
        return "adminlogin"; // Return the login page view
    }

    @GetMapping("/dashboard")
    public String showDashBoardPage() {
        return "admin-dashboard"; // Return the dashboard view
    }
    @GetMapping("/adduser")
    public String addUser(@ModelAttribute("admin") Admin admin, Model model) {
        return "adduser";
    }

    @GetMapping("/error")
    public String error(@ModelAttribute("admin") Admin admin, Model model) {
        return "error";
    }



    // Admin login validation (POST method)
    @PostMapping("/adminlogin")
    public String loginValid(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        try {
            Optional<Admin> admin = adminService.loginAdmin(email,password);


            if (admin.isPresent() ) {
                return "redirect:/dashboard"; // Redirect to dashboard if login is successful
            } else {
                model.addAttribute("errorMessage", "Invalid email or password"); // Show error
                return "adminlogin"; // Return to login page
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Login failed: " + e.getMessage());
            // Log the error if needed
            System.err.println("Login error: " + e.getMessage());
            return "adminlogin"; // Return to login page
        }
    }

    @PostMapping("/adduser")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("accountnumber") String accountnumber,
                          @RequestParam("ifscCode") String ifscCode,
                          @RequestParam("branch") String branch,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("role") String role,
                          RedirectAttributes redirectAttributes) {

        // Validation
        if (firstName.isEmpty() || lastName.isEmpty() ||
                accountnumber.isEmpty() || ifscCode.isEmpty() || branch.isEmpty() ||
                email.isEmpty() || password.isEmpty() || role.isEmpty()) {

            redirectAttributes.addFlashAttribute("errorMessage", "All fields are required.");
            return "redirect:/admin/error";
        }

        try {
            // Save user with all fields
            userService.registerUser(firstName, lastName,  accountnumber, ifscCode, branch, email, password, role);
            System.out.println("User added successfully!");
            return "redirect:/userdashboard";
        } catch (Exception e) {
            System.out.println("User registration failed: " + e.getMessage());
            return "redirect:/error";
        }
    }

    @GetMapping("/admin/listusers")
    public String showListUsers(Model model) {
        model.addAttribute("users", userRepository.findAll()); // Fetch all users from the database
        return "listusers"; // Return the listusers HTML view
    }
    

}
