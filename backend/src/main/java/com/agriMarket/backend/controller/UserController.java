package com.agriMarket.backend.controller;

import com.agriMarket.backend.model.User;
import com.agriMarket.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User newUser) {
        System.out.println("Received new user: " + newUser.getUsername());
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body(null); // Username taken
        }
        System.out.println("Encoding password for user: " + newUser.getPassword());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return ResponseEntity.ok(userRepository.save(newUser));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build(); // User not found
        }
        return ResponseEntity.ok(user);
    }
}