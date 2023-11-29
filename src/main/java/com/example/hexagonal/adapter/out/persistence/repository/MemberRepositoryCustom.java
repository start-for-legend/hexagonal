package com.example.hexagonal.adapter.out.persistence.repository;

import com.example.hexagonal.application.domain.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepositoryCustom {
    Optional<Member> findOneById(UUID memberId);
}
