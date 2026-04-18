package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrolUserInProgrammeRequest {

    @NotNull
    private Long userId;
    @NotNull
    private Long programmeId;
}
