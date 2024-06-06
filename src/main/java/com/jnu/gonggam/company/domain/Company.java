package com.jnu.gonggam.company.domain;

import com.jnu.gonggam.location.domain.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "company_tb")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_pk")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_pk")
    private Location location;

    @NotNull
    @Column(length = 45)
    private String name;

    @NotNull
    @Column(length = 20)
    private String telephone;

    @Column(length = 200)
    private String companyImagePath;
}
