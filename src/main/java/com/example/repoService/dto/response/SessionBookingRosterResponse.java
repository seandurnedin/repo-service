package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * All bookings for a session (used in admin/instructor view)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionBookingRosterResponse {
    private Long sessionId;
    private String sessionTitle;
    private LocalDate sessionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer maxCapacity;
    private int confirmedCount;
    private int availableSpots;
    private GymSummaryResponse gym;
    private List<BookingResponse> bookings;
}
