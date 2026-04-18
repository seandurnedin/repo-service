package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateGymRequest {

    @Size(max = 150)
    private String name;
    private String description;
    private String addressLine1;
    private String addressLine2;
    @Size(max = 100)
    private String city;
    @Size(max = 100)
    private String stateProvince;
    @Size(max = 20)
    private String postalCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    @Size(max = 30)
    private String phone;
    @Email
    @Size(max = 150)
    private String email;
    private String websiteUrl;
    @Min(1)
    private Integer capacity;
    private Boolean isActive;
    private List<String> amenities;
}
