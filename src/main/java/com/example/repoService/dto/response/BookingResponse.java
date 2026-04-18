package com.example.repoService.dto.response;

import com.example.repoService.constants.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {
    private Long id;
    private UserSummaryResponse user;
    private SessionSummaryResponse session;
    private BookingStatus status;
    private String notes;
    private LocalDateTime checkInTime;
    private LocalDateTime cancelledAt;
    private String cancellationReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
