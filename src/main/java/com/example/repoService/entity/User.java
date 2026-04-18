package com.example.repoService.entity;

import com.gymbooking.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 180)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    @Builder.Default
    private UserRole role = UserRole.MEMBER;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    // Home country
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_country_id")
    private Country homeCountry;

    // Bidirectional self-referencing friends list (Many-to-Many on same table)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_friends",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    @Builder.Default
    private List<User> friends = new ArrayList<>();

    // Gyms this user is a member of
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_gym_memberships",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    @Builder.Default
    private List<Gym> gymMemberships = new ArrayList<>();

    // Favourite gyms
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_favourite_gyms",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "gym_id")
    )
    @Builder.Default
    private List<Gym> favouriteGyms = new ArrayList<>();

    // Programmes this user is enrolled in
    @ManyToMany(mappedBy = "enrolledUsers", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Programme> enrolledProgrammes = new ArrayList<>();

    // Bookings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Booking> bookings = new ArrayList<>();
}
