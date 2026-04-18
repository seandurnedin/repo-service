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
public class UpdateSessionRequest {

    @Size(max = 150)
    private String title;
    private String description;
    private SessionType sessionType;
    private LocalTime startTime;
    private LocalTime endTime;
    @Min(1)
    private Integer maxCapacity;
    private Boolean isActive;
    private Long instructorId;
    private Long programmeId;
}
