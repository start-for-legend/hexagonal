package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.in.web.response.TeamResponse;
import com.example.hexagonal.application.domain.model.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ResponseMapper {

    static ResponseEntity<Set<TeamResponse>> mapToTeamResponse(Set<Team> team, HttpStatus status) {
        Set<TeamResponse> response = team.stream()
                .map(TeamResponse::fromEntity)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(response, status);
    }

    static ResponseEntity<TeamResponse> mapToTeamResponse(Team team, HttpStatus status) {
        TeamResponse response = TeamResponse.fromEntity(team);
        return new ResponseEntity<>(response, status);
    }
}
