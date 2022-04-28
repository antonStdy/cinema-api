package com.cinema.main.film.domain;

import com.cinema.main.film.domain.dto.command.*;
import com.cinema.main.film.domain.film.FilmId;

public interface FilmService {

    FilmId createFilm(CreateFilmCommand createFilmCommand);
}
