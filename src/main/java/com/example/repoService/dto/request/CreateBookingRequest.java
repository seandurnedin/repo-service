package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookingRequest {

    @NotNull
    private Long userId;
    @NotNull
    private Long sessionId;

    @Size(max = 500)
    private String notes;
}
