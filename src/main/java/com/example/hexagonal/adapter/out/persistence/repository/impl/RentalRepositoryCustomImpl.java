package com.example.hexagonal.adapter.out.persistence.repository.impl;

import com.example.hexagonal.adapter.out.persistence.repository.RentalRepositoryCustom;
import com.example.hexagonal.application.domain.model.QMember;
import com.example.hexagonal.application.domain.model.QTeam;
import com.example.hexagonal.application.domain.model.Rental;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.example.hexagonal.application.domain.model.QRental.rental;

@RequiredArgsConstructor
public class RentalRepositoryCustomImpl implements RentalRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public List<Rental> findByMemberId(UUID memberId) {
        return query.selectFrom(rental).distinct()
                .leftJoin(rental.team, QTeam.team).fetchJoin()
                .leftJoin(rental.member, QMember.member).fetchJoin()
                .fetch();
    }
}
