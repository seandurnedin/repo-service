
package com.example.repoService.dto;

import com.gymbooking.enums.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UpdateUserRequest {

    @Size(max = 80) private String firstName;
    @Size(max = 80) private String lastName;
    @Size(max = 30) private String phone;

    private LocalDate dateOfBirth;
    private String bio;
    private String profilePictureUrl;
    private Long homeCountryId;
}