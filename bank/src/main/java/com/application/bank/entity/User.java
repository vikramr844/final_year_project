package com.application.bank.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "accountnumber", unique = true, nullable = false)
    private String accountnumber;

    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "signup_date", nullable = false)
    private LocalDateTime signupDate;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public LocalDateTime getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(LocalDateTime signupDate) {
        this.signupDate = signupDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(String firstName, String lastName, String password, String accountnumber,
                String ifscCode, String branch, LocalDateTime signupDate, String role, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountnumber = accountnumber;
        this.ifscCode = ifscCode;
        this.branch = branch;
        this.signupDate = signupDate;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
