package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.adapter.out.persistence.repository.TeamRepository;
import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.out.LoadTeamPort;
import com.example.hexagonal.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class TeamPersistenceAdapter implements LoadTeamPort {
    private final TeamRepository teamRepository;

    @Override
    public Set<Team> loadAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return Set.copyOf(teams);
    }

    @Override
    public Optional<Team> loadTeamById(UUID id) {
        return teamRepository.findOneById(id);
    }
}
