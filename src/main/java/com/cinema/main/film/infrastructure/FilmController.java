package com.cinema.main.film.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.FilmService;
import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;
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

    @PostMapping
    public ResponseEntity<FilmId> create(@RequestBody CreateFilmCommand command) {
        FilmId id = filmService.createFilm(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Film> get(@PathVariable String id) {
        ResponseEntity<Film> response = filmService.getById(new FilmId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        return  response;
    }


}
