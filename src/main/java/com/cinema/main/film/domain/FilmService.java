package com.cinema.main.film.domain;

import com.cinema.main.film.domain.dto.command.*;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;

import java.util.Optional;
public interface FilmService {
    FilmId createFilm(CreateFilmCommand createFilmCommand);
    Optional<Film> getFilmById(FilmId id);

    void updateFilm(FilmId filmId, UpdateFilmCommand command);
}
