package com.cinema.main.film.domain.dto.command;

import lombok.Data;

import java.time.Duration;
import java.util.Date;

@Data
public class UpdateFilmCommand {
    private String name;
    private Date releaseDate;
    private Duration duration;
    private String description;
}
