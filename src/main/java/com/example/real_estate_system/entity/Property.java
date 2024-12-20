package com.example.real_estate_system.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.real_estate_system.common.enums.PropertyStatus;
import com.example.real_estate_system.common.enums.PropertyType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
public class Property extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String cityId;

    private String districtId;

    private String wardId;

    private String street;

    private String address;

    @Column(precision = 15, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private PropertyStatus status = PropertyStatus.AVAILABLE;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id")
    private Account owner; // Links to the account

    private String imagesFolderUrl;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<InterestedProperty> interestedProperties = new ArrayList<>();
}
