package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.in.web.request.RentTeamRequest;
import com.example.hexagonal.adapter.in.web.response.TeamResponse;
import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.in.GetRentTeamUseCase;
import com.example.hexagonal.application.port.in.GetTeamUseCase;
import com.example.hexagonal.application.port.in.RentTeamUseCase;
import com.example.hexagonal.application.port.in.command.RentTeamCommand;
import com.example.hexagonal.application.port.in.query.GetRentTeamQuery;
import com.example.hexagonal.application.port.in.query.GetTeamByIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamRentalController {

    private final GetTeamUseCase getTeamUseCase;
    private final GetRentTeamUseCase getRentTeamUseCase;
    private final RentTeamUseCase rentTeamUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<TeamResponse>> getAllTeams() {
        Set<Team> teams = getTeamUseCase.getAllTeams();
        return ResponseMapper.mapToTeamResponse(teams);
    }

    @GetMapping("/{memberId}/rentals")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<TeamResponse>> getRentTeam(@PathVariable("memberId") UUID memberId) {
        GetRentTeamQuery query = GetRentTeamQuery.builder()
                .memberId(memberId)
                .build();
        Set<Team> teams = getRentTeamUseCase.getRentTeamByMemberId(query);
        return ResponseMapper.mapToTeamResponse(teams);
    }

    @GetMapping("/{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable("teamId") UUID teamId) {
        GetTeamByIdQuery query = GetTeamByIdQuery.builder()
                .teamId(teamId)
                .build();
        Team team = getTeamUseCase.getTeamById(query);
        return ResponseMapper.mapToTeamResponse(team);
    }

    @PostMapping("/{teamSiteId}/{siteNumber}/rentals")
    @ResponseStatus(HttpStatus.CREATED)
    public void rentTeamSite(
            @PathVariable("teamSiteId") UUID teamSiteId,
            @PathVariable("siteNumber") int siteNumber,
            @RequestBody RentTeamRequest body
    ) {
        RentTeamCommand command = RentTeamCommand.builder()
                .memberId(body.memberId())
                .siteNumber(siteNumber)
                .teamId(teamSiteId)
                .build();
        rentTeamUseCase.rentTeam(command);
    }
}
