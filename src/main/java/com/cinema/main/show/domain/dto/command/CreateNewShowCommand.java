package com.cinema.main.show.domain.dto.command;

import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.dto.PriceDTO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class CreateNewShowCommand {
    private CinemaId cinemaId;
    private FilmId filmId;
    private Date date;
    private String sourceUrl;
    private List<PriceDTO> prices;
    private String primaryLanguage;
    private List<String> subtitlesLanguages;
}
