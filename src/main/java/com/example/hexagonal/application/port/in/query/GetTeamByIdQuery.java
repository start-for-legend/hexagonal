package com.example.hexagonal.application.port.in.query;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonal.common.validation.Validation.validate;

public record GetTeamByIdQuery(
        @NotNull(message = "teamId is required")
        UUID teamId
) {
    @Builder
    public GetTeamByIdQuery(
            UUID teamId
    ) {
        this.teamId = teamId;
        validate(this);
    }
}
