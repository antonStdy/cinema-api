package com.cinema.main.film.domain.film;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
public class BaseInfo {
    private final String name;
    private final Date releaseDate;
    private Duration duration;
    private String description;
}
