package com.cinema.main.cinema.domain;

import com.cinema.main.cinema.domain.dto.command.CinemaCreationCommand;

public interface CinemaFactory {
    Cinema createWithLocationCoordinates(CinemaCreationCommand cinemaCreationCommand);
}
