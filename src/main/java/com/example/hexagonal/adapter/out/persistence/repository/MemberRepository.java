package com.example.hexagonal.adapter.out.persistence.repository;

import com.example.hexagonal.application.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID>, MemberRepositoryCustom {
}
