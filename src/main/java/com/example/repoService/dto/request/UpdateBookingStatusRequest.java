package com.example.repoService.dto.request;

import com.example.repoService.constants.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBookingStatusRequest {

    @NotNull
    private BookingStatus status;

    @Size(max = 300)
    private String cancellationReason;
}
