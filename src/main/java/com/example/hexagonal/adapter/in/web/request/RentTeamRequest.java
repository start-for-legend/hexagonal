package com.example.hexagonal.adapter.in.web.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import static com.example.hexagonal.common.validation.Validation.validate;

public record RentTeamRequest(
    @NotNull(message = "memberId is required")
    UUID memberId
) {

    public RentTeamRequest(UUID memberId) {
        this.memberId = memberId;
        validate(this);
    }
}
