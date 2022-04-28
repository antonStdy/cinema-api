package com.cinema.main.show.domain.dto.command;

import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.Price;
import com.cinema.main.show.domain.dto.PriceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class CreateNewShowCommand {
    private final CinemaId cinemaId;
    private final FilmId filmId;
    private final Date date;
    private final String sourceUrl;
    private final List<PriceDTO> prices;
    private final String primaryLanguage;
    private final List<String> subtitlesLanguages;
}
