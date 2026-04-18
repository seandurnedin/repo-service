package com.example.repoService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "iso_code", nullable = false, unique = true, length = 3)
    private String isoCode;

    @Column(name = "phone_code", length = 10)
    private String phoneCode;

    @Column(name = "currency_code", length = 3)
    private String currencyCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Gym> gyms = new ArrayList<>();
}
