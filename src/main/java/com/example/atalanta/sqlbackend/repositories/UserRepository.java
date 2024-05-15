package com.example.atalanta.sqlbackend.repositories;

import com.example.atalanta.sqlbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
