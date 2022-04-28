package com.cinema.main.film.domain.dto.command;

import lombok.Data;

import java.util.Date;

@Data
public class CreateFilmCommand {
    String filmName;
    Date filmDate;
}
