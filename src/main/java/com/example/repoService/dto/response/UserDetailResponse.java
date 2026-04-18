package com.example.repoService.dto.response;

import com.example.repoService.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Full user profile — includes nested friend list, memberships, programmes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String profilePictureUrl;
    private String bio;
    private UserRole role;
    private Boolean isActive;

    private CountryResponse homeCountry;

    /**
     * Flat friend list — uses summary to avoid deep nesting
     */
    private List<UserSummaryResponse> friends;
    private int friendCount;

    /**
     * Gyms the user has a membership to
     */
    private List<GymSummaryResponse> gymMemberships;

    /**
     * Gyms the user has favourited
     */
    private List<GymSummaryResponse> favouriteGyms;

    /**
     * Programmes the user is enrolled in
     */
    private List<ProgrammeSummaryResponse> enrolledProgrammes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
