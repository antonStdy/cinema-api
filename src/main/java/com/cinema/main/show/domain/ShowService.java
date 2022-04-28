package com.cinema.main.show.domain;

import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;

import java.util.Optional;

public interface ShowService {
    ShowId create(CreateNewShowCommand createNewShowCommand);

    Optional<Show> getById(ShowId cinemaId);
}
