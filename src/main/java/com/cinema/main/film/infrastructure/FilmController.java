package com.cinema.main.film.infrastructure;

import com.cinema.main.film.domain.FilmFactory;
import com.cinema.main.film.domain.FilmService;
import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.dto.command.UpdateFilmCommand;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/film")
@Slf4j
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;
    private final FilmFactory filmFactory;

    @PostMapping
    public ResponseEntity<FilmId> create(@RequestBody CreateFilmCommand command) {
        FilmId id = filmService.createFilm(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Film> get(@PathVariable String id) {
        FilmId filmId = new FilmId();
        filmId.setId(id);
        ResponseEntity<Film> response = filmService.getFilmById(filmId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        return  response;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable String id,
                       @RequestBody UpdateFilmCommand command) {
        FilmId filmId = filmFactory.filmIdFromString(id);
        filmService.updateFilm(filmId, command);
    }
}
