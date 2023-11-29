package com.example.hexagonal.adapter.out.persistence;

import com.example.hexagonal.adapter.out.persistence.repository.MemberRepository;
import com.example.hexagonal.application.domain.model.Member;
import com.example.hexagonal.application.port.out.LoadMemberPort;
import com.example.hexagonal.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort {
    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> loadMemberById(UUID memberId) {
        return memberRepository.findOneById(memberId);
    }
}
