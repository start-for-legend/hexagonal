package com.example.hexagonal.application.domain.model;

import com.example.hexagonal.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Entity
@Table(name = "team", indexes = {@Index(name = "idx_team_id", columnList = "id", unique = true)})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "camp_site_site_number", joinColumns = @JoinColumn(name = "camp_site_id"))
    @Column(name = "site_number", nullable = false)
    private int[] siteNumber;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();

    @Builder
    Team(@NonNull String name, @NonNull int[] siteNumber) {
        this.name = name;
        this.siteNumber = siteNumber;
    }
}
