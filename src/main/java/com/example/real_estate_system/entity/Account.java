package com.example.real_estate_system.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.real_estate_system.common.enums.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
public class Account extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile; // Links to the account

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<InterestedProperty> interestedProperties = new ArrayList<>();
}
