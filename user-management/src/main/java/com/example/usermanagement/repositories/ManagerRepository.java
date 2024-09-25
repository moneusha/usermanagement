package com.example.usermanagement.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.models.Manager;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
    Optional<Manager> findByIdAndIsActiveTrue(UUID managerId);
}
