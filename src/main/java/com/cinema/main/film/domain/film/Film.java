package com.cinema.main.film.domain.film;

import com.cinema.main.film.domain.dto.command.UpdateFilmCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
@Getter
public class Film {
    private final FilmId id;
    private final BaseInfo baseInfo;

    public void update(UpdateFilmCommand command) {
        baseInfo.setDescription(command.getDescription());
        baseInfo.setReleaseDate(command.getReleaseDate());
    }
}
