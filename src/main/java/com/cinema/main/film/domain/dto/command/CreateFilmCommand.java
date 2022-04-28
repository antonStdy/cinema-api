package com.cinema.main.film.domain.dto.command;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class CreateFilmCommand {
    String filmName;
    Date filmDate;
}
