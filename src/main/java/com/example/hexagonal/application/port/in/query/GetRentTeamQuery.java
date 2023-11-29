package com.example.hexagonal.application.port.in.query;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonal.common.validation.Validation.validate;

public record GetRentTeamQuery (
        @NotNull(message = "memberId is required")
        UUID memberId
) {

    @Builder
    public GetRentTeamQuery(
            UUID memberId
    ) {
        this.memberId = memberId;
        validate(memberId);
    }
}

