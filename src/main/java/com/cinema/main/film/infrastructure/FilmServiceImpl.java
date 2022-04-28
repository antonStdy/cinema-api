package com.cinema.main.film.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.FilmFactory;
import com.cinema.main.film.domain.FilmRepository;
import com.cinema.main.film.domain.FilmService;
import com.cinema.main.film.domain.dto.command.*;
import com.cinema.main.film.domain.exception.FilmNotFoundException;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmFactory factory;
    private final FilmRepository repository;

    @Override
    public FilmId createFilm(CreateFilmCommand createFilmCommand) {
        Film film = factory.createNew(createFilmCommand);
        repository.save(film);
        return film.getId();
    }
    @Override
    public Optional<Film> getById(FilmId id) {
        return repository.findById(id);
    }
}
