package com.application.bank.repo;

import com.application.bank.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);
    Admin findByPassword(String password);
}
