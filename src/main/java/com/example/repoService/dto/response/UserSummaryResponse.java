package com.example.repoService.dto.response;

import com.example.repoService.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSummaryResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePictureUrl;
    private UserRole role;
    private Boolean isActive;
}
