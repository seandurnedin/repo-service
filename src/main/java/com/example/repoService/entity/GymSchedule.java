package com.example.repoService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A GymSchedule is the top-level calendar container for a Gym.
 * It holds a list of ScheduleDay entries — one per calendar date —
 * each of which holds the sessions running on that day.
 */
@Entity
@Table(name = "gym_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymSchedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", length = 150)
    private String label; // e.g. "2025 Annual Schedule", "Summer Programme Schedule"

    @Column(name = "timezone", nullable = false, length = 60)
    @Builder.Default
    private String timezone = "UTC";

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id", nullable = false, unique = true)
    private Gym gym;

    // One schedule has many days (365+ entries per year)
    @OneToMany(mappedBy = "gymSchedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("date ASC")
    @Builder.Default
    private List<ScheduleDay> scheduleDays = new ArrayList<>();
}
