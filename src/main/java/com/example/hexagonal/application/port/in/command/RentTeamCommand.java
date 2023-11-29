package com.example.hexagonal.application.port.in.command;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonal.common.validation.Validation.validate;

public record RentTeamCommand(
        @NotNull(message = "teamId is required")
        UUID teamId,
        @NotNull(message = "memberId is required")
        UUID memberId,
        @NotNull(message = "siteNumber is required")
        int siteNumber
) {

    @Builder
    public RentTeamCommand(
            UUID teamId,
            UUID memberId,
            int siteNumber
    ) {
        this.teamId = teamId;
        this.memberId = memberId;
        this.siteNumber = siteNumber;
        validate(this);
    }
}
