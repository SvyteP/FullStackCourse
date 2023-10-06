package com.example.FullStackCourse.repository;


import com.example.FullStackCourse.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);


    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long id);
}
