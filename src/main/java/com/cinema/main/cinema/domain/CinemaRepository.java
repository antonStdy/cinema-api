package com.cinema.main.cinema.domain;

import java.util.Optional;

// TODO implement
public interface CinemaRepository {
    void save(Cinema cinema);
    Optional<Cinema> findById(CinemaId id);
}
