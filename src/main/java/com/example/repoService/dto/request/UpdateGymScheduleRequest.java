package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGymScheduleRequest {

    @Size(max = 150)
    private String label;
    @Size(max = 60)
    private String timezone;
    private Boolean isActive;
}
