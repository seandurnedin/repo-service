package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Full schedule — includes all ScheduleDays each with their Sessions.
 * Ideal for calendar views or admin panels.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymScheduleDetailResponse {
    private Long id;
    private String label;
    private String timezone;
    private Boolean isActive;

    private GymSummaryResponse gym;

    /**
     * Ordered list of days — each day contains its sessions
     */
    private List<ScheduleDayResponse> scheduleDays;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
