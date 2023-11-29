package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.adapter.out.persistence.repository.RentalRepository;
import com.example.hexagonal.application.domain.model.Member;
import com.example.hexagonal.application.domain.model.Rental;
import com.example.hexagonal.application.domain.model.Team;
import com.example.hexagonal.application.port.out.InsertRentPort;
import com.example.hexagonal.application.port.out.LoadRentTeamPort;
import com.example.hexagonal.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class RentalPersistenceAdapter implements LoadRentTeamPort, InsertRentPort {
    private final RentalRepository rentalRepository;

    @Override
    public Set<Team> loadRentTeamsByMemberId(UUID memberId) {
        List<Rental> rentals = rentalRepository.findByMemberId(memberId);
        if(rentals.isEmpty()) {
            return Set.of();
        }

        List<Team> teams = rentals.stream()
                .map(Rental::getTeam)
                .collect(Collectors.toList());

        return Set.copyOf(teams);
    }

    @Override
    public void insertRent(Member member, Team team) {
        Rental rental = Rental.builder()
                .member(member)
                .team(team)
                .build();
        rentalRepository.save(rental);
    }
}
