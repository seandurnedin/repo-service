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
public class CreateProgrammeRequest {

    @NotBlank
    @Size(max = 150)
    private String name;
    private String description;

    @NotNull
    private ProgrammeDifficulty difficulty;

    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

    @Min(1)
    private Integer maxParticipants;

    @DecimalMin("0.00")
    private BigDecimal price;

    @NotNull
    private Long gymId;
    private Long leadTrainerId;
}
