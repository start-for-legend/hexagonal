package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.in.query.GetRentTeamQuery;

import java.util.Set;

public interface GetRentTeamUseCase {
    Set<Team> getRentTeamByMemberId(GetRentTeamQuery query);
}
