package com.example.hexagonal.adapter.out.persistence.repository.impl;

import com.example.hexagonal.adapter.out.persistence.repository.TeamRepositoryCustom;
import com.example.hexagonal.application.domain.model.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import static com.example.hexagonal.application.domain.model.QRental.rental;
import static com.example.hexagonal.application.domain.model.QTeam.team;

@RequiredArgsConstructor
public class TeamRepositoryCustomImpl implements TeamRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public Optional<Team> findOneById(UUID id) {
    return Optional.ofNullable(query.selectFrom(team)
            .leftJoin(team.rentals, rental)
            .where(team.id.eq(id))
            .fetchOne());
    }
}
