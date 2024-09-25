package com.example.usermanagement.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Lombok will generate getter, setter, toString, equals, and hashCode methods
@NoArgsConstructor  // No-argument constructor
@AllArgsConstructor  // All-argument constructor
@Entity
public class Manager {

    @Id
    private UUID managerId;

    @Column(nullable = false)
    private String managerName;

    private Boolean isActive = true;
}
