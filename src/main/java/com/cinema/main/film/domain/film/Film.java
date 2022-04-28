package com.cinema.main.film.domain.film;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
public class Film {
    @Getter
    private final FilmId id;
    private final BaseInfo baseInfo;
}
