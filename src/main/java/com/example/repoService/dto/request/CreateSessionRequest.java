package com.example.repoService.dto.request;

import com.example.repoService.constants.SessionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSessionRequest {

    @NotBlank
    @Size(max = 150)
    private String title;
    private String description;

    @NotNull
    private SessionType sessionType;

    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;

    @NotNull
    @Min(1)
    private Integer maxCapacity;

    private Long instructorId;

    @NotNull
    private Long scheduleDayId;

    // Optional: attach directly to a programme
    private Long programmeId;
}
