package com.example.repoService.dto.response;

import com.example.repoService.constants.SessionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * Lightweight session — embedded inside ScheduleDayResponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionSummaryResponse {
    private Long id;
    private String title;
    private SessionType sessionType;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer maxCapacity;
    private int bookedCount;
    private int availableSpots;
    private Boolean isActive;
    private UserSummaryResponse instructor;
    private Long programmeId;
    private String programmeName;
}
