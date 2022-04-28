package com.cinema.main.show.domain;

import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.languageinfo.LanguageInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class Show {
    @Getter
    private final ShowId id;
    private final CinemaId cinemaId;
    private final FilmId filmId;
    private final Date date;
    private final List<Price> prices;
    private final LanguageInfo languageInfo;
    private final String sourceUrl;
}
