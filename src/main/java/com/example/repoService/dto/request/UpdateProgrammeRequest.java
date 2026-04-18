package com.example.repoService.dto.request;

import com.example.repoService.constants.ProgrammeDifficulty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProgrammeRequest {

    @Size(max = 150)
    private String name;
    private String description;
    private ProgrammeDifficulty difficulty;
    private LocalDate startDate;
    private LocalDate endDate;
    @Min(1)
    private Integer maxParticipants;
    @DecimalMin("0.00")
    private BigDecimal price;
    private Boolean isActive;
    private Long leadTrainerId;
}
