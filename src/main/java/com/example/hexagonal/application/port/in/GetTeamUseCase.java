package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.in.query.GetTeamByIdQuery;

import java.util.Set;

public interface GetTeamUseCase {
    Set<Team> getAllTeams();

    Team getTeamById(GetTeamByIdQuery query);
}
