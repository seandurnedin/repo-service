package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank
    @Size(max = 80)
    private String firstName;

    @NotBlank
    @Size(max = 80)
    private String lastName;

    @NotBlank
    @Email
    @Size(max = 180)
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    @Size(max = 30)
    private String phone;

    private LocalDate dateOfBirth;

    private Long homeCountryId;
}
