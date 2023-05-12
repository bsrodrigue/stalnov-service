package com.example.novelservice.common.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // This method will be called before the entity is persisted
    // It will set createdAt and updatedAt fields
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // This method will be called before the entity is updated
    // It will update the updatedAt field
    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
