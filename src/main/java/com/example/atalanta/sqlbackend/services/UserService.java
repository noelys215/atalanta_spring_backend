package com.example.atalanta.sqlbackend.services;

import com.example.atalanta.sqlbackend.models.User;
import com.example.atalanta.sqlbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.hashPassword(passwordEncoder);
        return userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean checkPassword(User user, String enteredPassword) {
        return user.matchPassword(enteredPassword, passwordEncoder);
    }
}