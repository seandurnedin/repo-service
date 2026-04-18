package com.example.repoService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResponse {
    private Long id;
    private String name;
    private String isoCode;
    private String phoneCode;
    private String currencyCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
