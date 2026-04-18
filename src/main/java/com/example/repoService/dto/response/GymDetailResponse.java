package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Full gym detail — includes schedule, programmes, members
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GymDetailResponse {
    private Long id;
    private String name;
    private String description;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String phone;
    private String email;
    private String websiteUrl;
    private Integer capacity;
    private Boolean isActive;
    private List<String> amenities;

    private CountryResponse country;

    /**
     * The gym's schedule (summary — days not eagerly loaded here)
     */
    private GymScheduleSummaryResponse schedule;

    /**
     * All programmes currently offered
     */
    private List<ProgrammeSummaryResponse> programmes;

    /**
     * Registered members
     */
    private List<UserSummaryResponse> members;
    private int memberCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
