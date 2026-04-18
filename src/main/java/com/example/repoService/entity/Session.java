package com.example.repoService.entity;

import com.gymbooking.enums.SessionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A Session is a single bookable time-slot within a ScheduleDay.
 * Sessions can optionally belong to a Programme.
 */
@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Session extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "session_type", nullable = false, length = 30)
    private SessionType sessionType;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    // The instructor/trainer leading this session (nullable — could be open gym)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private User instructor;

    // Which day this session belongs to
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_day_id", nullable = false)
    private ScheduleDay scheduleDay;

    // Optional link to a Programme (if this session is part of one)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programme_id")
    private Programme programme;

    // All bookings for this session
    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Booking> bookings = new ArrayList<>();
}
