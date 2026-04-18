package com.example.repoService.entity;

import com.gymbooking.enums.ProgrammeDifficulty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A Programme is a structured course or challenge offered by a Gym
 * (e.g. "12-Week Weight Loss", "Beginner Yoga Block", "Summer HIIT Challenge").
 * It spans a date range and groups a set of Sessions.
 * Users can enrol into a Programme.
 */
@Entity
@Table(name = "programmes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Programme extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false, length = 20)
    @Builder.Default
    private ProgrammeDifficulty difficulty = ProgrammeDifficulty.BEGINNER;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "max_participants")
    private Integer maxParticipants;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    // The gym offering this programme
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    // Lead trainer / coach for the programme
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_trainer_id")
    private User leadTrainer;

    // All sessions that belong to this programme
    @OneToMany(mappedBy = "programme", fetch = FetchType.LAZY)
    @OrderBy("scheduleDay.date ASC, startTime ASC")
    @Builder.Default
    private List<Session> sessions = new ArrayList<>();

    // Users enrolled in this programme
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "programme_enrollments",
        joinColumns = @JoinColumn(name = "programme_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Builder.Default
    private List<User> enrolledUsers = new ArrayList<>();
}
