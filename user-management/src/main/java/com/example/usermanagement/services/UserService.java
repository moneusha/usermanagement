package com.example.usermanagement.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.models.User;
import com.example.usermanagement.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setFullName(user.getFullName().toUpperCase());  // Example logic
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByMobNum(String mobNum) {
        return userRepository.findByMobNum(mobNum);
    }

    public List<User> getUsersByManagerId(UUID managerId) {
        return userRepository.findByManagerId(managerId);
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(UUID userId, User newUserDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setFullName(newUserDetails.getFullName());
            user.setMobNum(newUserDetails.getMobNum());
            user.setPanNum(newUserDetails.getPanNum());
            user.setManagerId(newUserDetails.getManagerId());
            user.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
