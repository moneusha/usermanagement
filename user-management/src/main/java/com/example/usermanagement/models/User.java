package com.example.usermanagement.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Lombok will generate getter, setter, toString, equals, and hashCode methods
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String mobNum;

    @Column(nullable = false, unique = true)
    private String panNum;

    private UUID managerId;

    private Boolean isActive = true;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
