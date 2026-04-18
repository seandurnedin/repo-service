package com.example.repoService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gyms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gym extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state_province", length = 100)
    private String stateProvince;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    // The gym's weekly/annual schedule
    @OneToOne(mappedBy = "gym", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private GymSchedule schedule;

    // Programmes offered at this gym
    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Programme> programmes = new ArrayList<>();

    // Members of this gym
    @ManyToMany(mappedBy = "gymMemberships", fetch = FetchType.LAZY)
    @Builder.Default
    private List<User> members = new ArrayList<>();

    // Amenities (e.g. "Pool", "Sauna", "Parking")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "gym_amenities", joinColumns = @JoinColumn(name = "gym_id"))
    @Column(name = "amenity")
    @Builder.Default
    private List<String> amenities = new ArrayList<>();
}
