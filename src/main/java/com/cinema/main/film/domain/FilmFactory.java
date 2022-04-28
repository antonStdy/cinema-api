package com.cinema.main.film.domain;

import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;

public interface FilmFactory {
    Film createNew(CreateFilmCommand command);
    FilmId filmIdFromString(String id);
}
