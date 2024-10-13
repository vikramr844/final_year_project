package com.application.bank.repo;

import com.application.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query to count new signups today
    @Query("SELECT COUNT(u) FROM User u WHERE DATE(u.signupDate) = :today")
    long countNewSignupsToday(@Param("today") LocalDate today);

    // Custom query to get all users
    @Query("SELECT u FROM User u")
    List<User> findAllUser();


    @Query("SELECT COUNT(u) FROM User u WHERE u.signupDate = CURRENT_DATE")
    long getNewSignupsToday();
    // Corrected query to count total users
    @Query("SELECT COUNT(u.id) FROM User u")
    long countTotalUsers();

    @Query("SELECT COUNT(u.id) FROM User u")
    long getTotalUsers();

    Optional<User> findByEmail(String email);


//    @Query("SELECT COUNT(s) FROM Session s WHERE s.status = 'active'") // Example for active sessions
//    long getActiveSessions();


}
