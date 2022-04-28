package com.cinema.main.film.domain;

import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;

import java.util.Optional;

public interface FilmRepository {
    void save(Film film);
    Optional<Film> getById(FilmId filmId);
}
