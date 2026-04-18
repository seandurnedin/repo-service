package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateScheduleDayRequest {

    @NotNull
    private java.time.LocalDate date;

    private String note;

    @Builder.Default
    private Boolean isClosed = false;

    @NotNull
    private Long gymScheduleId;

    // Optionally seed sessions on the same request
    private List<CreateSessionRequest> sessions;
}
