package com.cinema.main.film.infrastructure;

import com.cinema.main.film.domain.FilmRepository;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class InMemoryFilmRepository implements FilmRepository {
    private final Map<FilmId, Film> films = new HashMap<>();

    @Override
    public void save(Film film) {
        if (!exists(film)) {
            films.put(film.getId(), film);
            log.info("film saved: {}", film);
        }
    }

    @Override
    public Optional<Film> getById(FilmId filmId) {
        if (!films.containsKey(filmId)) {
            return Optional.empty();
        }
        return Optional.of(films.get(filmId));
    }

    @Override
    public Optional<Film> findById(FilmId id) {
        if (films.containsKey(id)) {
            return Optional.of(films.get(id));
        } else {
            return Optional.empty();
        }
    }

    private boolean exists(Film film) {
        return getById(film.getId()).isPresent();
    }
}
