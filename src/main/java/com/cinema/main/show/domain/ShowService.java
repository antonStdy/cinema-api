package com.cinema.main.show.domain;

import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;

public interface ShowService {
    ShowId create(CreateNewShowCommand createNewShowCommand);
}
