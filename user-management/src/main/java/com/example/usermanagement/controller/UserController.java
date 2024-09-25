package com.example.usermanagement.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagement.models.User;
import com.example.usermanagement.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully!");
    }

    @GetMapping("/get_users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/delete_user")
    public ResponseEntity<String> deleteUser(@RequestParam UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully!");
    }

    @PostMapping("/update_user")
    public ResponseEntity<String> updateUser(@RequestParam UUID userId, @RequestBody User userDetails) {
        userService.updateUser(userId, userDetails);
        return ResponseEntity.ok("User updated successfully!");
    }
}

