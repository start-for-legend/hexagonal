package com.example.hexagonal.adapter.out.persistence.repository;

import com.example.hexagonal.application.domain.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental, UUID>, RentalRepositoryCustom {
}
