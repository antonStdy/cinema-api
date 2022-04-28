package com.cinema.main.film.infrastructure;

import com.cinema.main.film.domain.FilmService;
import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.FilmId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
