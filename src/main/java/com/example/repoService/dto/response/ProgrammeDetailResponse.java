package com.example.repoService.dto.response;

import com.example.repoService.constants.ProgrammeDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Full programme detail — includes sessions, enrolled users, trainer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammeDetailResponse {
    private Long id;
    private String name;
    private String description;
    private ProgrammeDifficulty difficulty;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxParticipants;
    private BigDecimal price;
    private Boolean isActive;

    private GymSummaryResponse gym;
    private UserSummaryResponse leadTrainer;

    /**
     * All sessions belonging to this programme,
     * ordered by date then start time.
     */
    private List<SessionSummaryResponse> sessions;
    private int totalSessions;

    /**
     * Users enrolled in this programme
     */
    private List<UserSummaryResponse> enrolledUsers;
    private int enrolledCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
