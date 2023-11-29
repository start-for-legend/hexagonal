package com.example.hexagonal.application.port.out;

import com.example.hexagonal.application.domain.model.Team;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface LoadTeamPort {

    Set<Team> loadAllTeams();

    Optional<Team> loadTeamById(UUID id);
}
