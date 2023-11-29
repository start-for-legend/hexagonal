package com.example.hexagonal.application.port.out;

import com.example.hexagonal.application.domain.model.Member;
import com.example.hexagonal.application.domain.model.Team;

public interface InsertRentPort {

    void insertRent(Member member, Team team);
}
