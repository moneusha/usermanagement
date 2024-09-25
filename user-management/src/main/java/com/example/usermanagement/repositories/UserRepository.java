package com.example.usermanagement.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByMobNum(String mobNum);
    List<User> findByManagerId(UUID managerId);
}
