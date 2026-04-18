package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Summary — attached to GymDetailResponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymScheduleSummaryResponse {
    private Long id;
    private String label;
    private String timezone;
    private Boolean isActive;
    private int totalDays;
    private LocalDateTime updatedAt;
}
