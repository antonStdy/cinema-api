package com.cinema.main.film.domain;

import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.Film;

public interface FilmFactory {
    Film createNew(CreateFilmCommand command);
}
