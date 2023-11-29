package com.example.hexagonal.application.port.in;

import com.example.hexagonal.application.port.in.command.RentTeamCommand;

public interface RentTeamUseCase {
    void rentTeam(RentTeamCommand command);
}
