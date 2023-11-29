package com.example.hexagonal.application.domain.service;

import com.example.hexagonal.application.domain.model.Member;
import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.in.GetRentTeamUseCase;
import com.example.hexagonal.application.port.in.GetTeamUseCase;
import com.example.hexagonal.application.port.in.RentTeamUseCase;
import com.example.hexagonal.application.port.in.command.RentTeamCommand;
import com.example.hexagonal.application.port.in.query.GetRentTeamQuery;
import com.example.hexagonal.application.port.in.query.GetTeamByIdQuery;
import com.example.hexagonal.application.port.out.InsertRentPort;
import com.example.hexagonal.application.port.out.LoadMemberPort;
import com.example.hexagonal.application.port.out.LoadRentTeamPort;
import com.example.hexagonal.application.port.out.LoadTeamPort;
import com.example.hexagonal.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@UseCase
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamRentalService implements GetTeamUseCase, GetRentTeamUseCase, RentTeamUseCase {
    private final LoadTeamPort loadTeamPort;
    private final LoadRentTeamPort loadRentTeamPort;
    private final InsertRentPort insertRentPort;
    private final LoadMemberPort loadMemberPort;

    @Override
    public Set<Team> getRentTeamByMemberId(GetRentTeamQuery query) {
        return loadRentTeamPort.loadRentTeamsByMemberId(query.memberId());
    }

    @Override
    public Set<Team> getAllTeams() {
        return loadTeamPort.loadAllTeams();
    }

    @Override
    public Team getTeamById(GetTeamByIdQuery query) {
        return loadTeamPort.loadTeamById(query.teamId())
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    @Transactional
    public void rentTeam(RentTeamCommand command) {
        Member member = getMemberById(command.memberId());
        GetTeamByIdQuery query = GetTeamByIdQuery.builder()
                .teamId(command.teamId())
                .build();
        Team team = getTeamById(query);
        insertRentPort.insertRent(member, team);
    }

    private Member getMemberById(UUID memberId) {
        return loadMemberPort.loadMemberById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}
