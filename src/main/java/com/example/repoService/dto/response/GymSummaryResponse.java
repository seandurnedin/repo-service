package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lightweight gym — used in user memberships, programme listings
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymSummaryResponse {
    private Long id;
    private String name;
    private String city;
    private String stateProvince;
    private CountryResponse country;
    private Boolean isActive;
}
