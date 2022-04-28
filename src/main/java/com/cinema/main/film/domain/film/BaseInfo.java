package com.cinema.main.film.domain.film;

import lombok.Data;

import java.time.Duration;
import java.util.Date;

@Data
public class BaseInfo {
    private String name;
    private Date releaseDate;
    private String description;
}
