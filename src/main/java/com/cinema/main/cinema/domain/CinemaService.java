package com.cinema.main.cinema.domain;

import com.cinema.main.cinema.domain.dto.command.CinemaCreationCommand;
import com.cinema.main.cinema.domain.dto.view.SavedCinemaId;

import java.util.Optional;

public interface CinemaService {
    SavedCinemaId create(CinemaCreationCommand cinemaCreationCommand);
    Optional<Cinema> getById(CinemaId id);
}
