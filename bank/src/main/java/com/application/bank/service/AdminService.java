package com.application.bank.service;


import com.application.bank.entity.Admin;
import com.application.bank.repo.AdminRepository;
import com.application.bank.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to login an admin
    public Optional<Admin> loginAdmin(String email,String password) throws Exception {
        Optional<Admin> adminemail = Optional.ofNullable(adminRepository.findByEmail(email));
        Optional<Admin> adminpass = Optional.ofNullable(adminRepository.findByPassword(password));

        if (adminemail.isPresent() && adminpass.get().getPassword().equals(password)) {
            // Successful login
            return adminemail;
        } else {
            // If username or password is incorrect
            throw new Exception("Invalid username or password.");
        }
    }


}
