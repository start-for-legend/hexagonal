package com.example.hexagonal.adapter.in.web.response;

import com.example.hexagonal.application.domain.model.Team;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonal.common.validation.Validation.validate;

public record TeamResponse(
        @NotNull UUID id,
        @NotNull int[] siteNumber
) {

    @Builder
    public TeamResponse(
            UUID id,
            int[] siteNumber
    ) {
        this.id = id;
        this.siteNumber = siteNumber;
        validate(this);
    }

    public static TeamResponse fromEntity(Team entity) {
        return TeamResponse.builder()
                .id(entity.getId())
                .siteNumber(entity.getSiteNumber())
                .build();
    }
}
