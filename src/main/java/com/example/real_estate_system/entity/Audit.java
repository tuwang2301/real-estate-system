package com.example.real_estate_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public class Audit {

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdBy = "system"; // Use dynamic user if needed
        this.updatedBy = "system"; // Use dynamic user if needed
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = "system"; // Use dynamic user if needed
    }
}