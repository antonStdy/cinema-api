package com.cinema.main.film.domain.exception;

import com.cinema.main.film.domain.film.FilmId;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(FilmId id, Throwable e) {
        super("Film not found, id: " + id, e);
    }
    public FilmNotFoundException(FilmId id) {
        super("Film not found, id: " + id);
    }
}
