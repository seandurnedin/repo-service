package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A single day entry with all its sessions
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDayResponse {
    private Long id;
    private LocalDate date;
    private String note;
    private Boolean isClosed;

    /**
     * All sessions on this day, ordered by startTime
     */
    private List<SessionSummaryResponse> sessions;
    private int sessionCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
