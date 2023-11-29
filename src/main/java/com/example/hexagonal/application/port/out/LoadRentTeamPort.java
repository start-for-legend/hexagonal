package com.example.hexagonal.application.port.out;

import com.example.hexagonal.application.domain.model.Team;

import java.util.Set;
import java.util.UUID;

public interface LoadRentTeamPort {

    Set<Team> loadRentTeamsByMemberId(UUID memberId);
}
