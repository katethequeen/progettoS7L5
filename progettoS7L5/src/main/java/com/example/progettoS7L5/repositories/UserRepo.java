package com.example.progettoS7L5.repositories;

import com.example.progettoS7L5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
