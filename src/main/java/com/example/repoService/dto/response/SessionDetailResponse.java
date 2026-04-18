package com.example.repoService.dto.response;

import com.example.repoService.constants.SessionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Full session detail — includes bookings list
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionDetailResponse {
    private Long id;
    private String title;
    private String description;
    private SessionType sessionType;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer maxCapacity;
    private int bookedCount;
    private int availableSpots;
    private Boolean isActive;

    private UserSummaryResponse instructor;

    /**
     * The day this session belongs to
     */
    private LocalDate sessionDate;
    private GymSummaryResponse gym;

    /**
     * Programme this session is part of (nullable)
     */
    private ProgrammeSummaryResponse programme;

    /**
     * All bookings for this session
     */
    private List<BookingResponse> bookings;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
