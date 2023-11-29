package com.example.hexagonal.adapter.out.persistence.repository;

import com.example.hexagonal.application.domain.model.Rental;

import java.util.List;
import java.util.UUID;

public interface RentalRepositoryCustom {
    List<Rental> findByMemberId(UUID memberId);
}
