package com.example.hexagonal.adapter.out.persistence.repository;

import com.example.hexagonal.application.domain.model.Team;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepositoryCustom {
    Optional<Team> findOneById(UUID id);
}
