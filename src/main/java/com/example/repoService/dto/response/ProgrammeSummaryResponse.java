package com.example.repoService.dto.response;

import com.example.repoService.constants.ProgrammeDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Lightweight programme — used in user enrolments, gym detail
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammeSummaryResponse {
    private Long id;
    private String name;
    private ProgrammeDifficulty difficulty;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price;
    private Boolean isActive;
    private GymSummaryResponse gym;
}
