package com.example.repoService.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCountryRequest {

    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(min = 2, max = 3)
    private String isoCode;
    @Size(max = 10)
    private String phoneCode;
    @Size(max = 3)
    private String currencyCode;
}
