package com.application.bank.service;

import com.application.bank.entity.User;
import com.application.bank.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



//    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Customer login
    public User userlogin(String email, String password) throws Exception {
        Optional<User> customerOpt = userRepository.findByEmail(email);
        if (customerOpt.isPresent()) {
            User customer = customerOpt.get();
            if (customer.getPassword().equals(password)) {
                return customer;
            } else {
                throw new Exception("Invalid password!");
            }
        } else {
            throw new Exception("Customer not found!");
        }
    }
    public User registerUser(String firstName, String lastName, String accountnumber,
                             String ifscCode, String branch, String email, String password, String role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAccountnumber(accountnumber);
        user.setIfscCode(ifscCode);
        user.setBranch(branch);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setSignupDate(LocalDateTime.now()); // Set signup date to current time

        return userRepository.save(user); // Save user to the database
    }


}
