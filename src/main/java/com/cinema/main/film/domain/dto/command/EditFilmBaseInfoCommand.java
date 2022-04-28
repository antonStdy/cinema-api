package com.cinema.main.film.domain.dto.command;

import com.cinema.main.film.domain.film.BaseInfo;
import com.cinema.main.film.domain.film.FilmId;
import lombok.Data;

@Data
public class EditFilmBaseInfoCommand {
    private final FilmId filmId;
    private final BaseInfo filmBaseInfo;
}
