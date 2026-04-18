package com.example.repoService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single calendar day within a GymSchedule.
 * Each ScheduleDay owns an ordered list of Session entries for that date.
 */
@Entity
@Table(
    name = "schedule_days",
    uniqueConstraints = @UniqueConstraint(
        name = "uq_schedule_date",
        columnNames = {"gym_schedule_id", "date"}
    )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDay extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "note", length = 300) // e.g. "Bank Holiday — limited hours"
    private String note;

    @Column(name = "is_closed", nullable = false)
    @Builder.Default
    private Boolean isClosed = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_schedule_id", nullable = false)
    private GymSchedule gymSchedule;

    // All sessions running on this calendar day
    @OneToMany(mappedBy = "scheduleDay", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("startTime ASC")
    @Builder.Default
    private List<Session> sessions = new ArrayList<>();
}
