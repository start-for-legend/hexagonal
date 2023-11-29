package com.example.hexagonal.application.port.out;

import com.example.hexagonal.application.domain.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface LoadMemberPort {

    Optional<Member> loadMemberById(UUID memberId);
}
