package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A user's full booking history
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBookingHistoryResponse {
    private Long userId;
    private String fullName;
    private List<BookingResponse> bookings;
    private int totalBookings;
    private int completedCount;
    private int cancelledCount;
    private int upcomingCount;
}
