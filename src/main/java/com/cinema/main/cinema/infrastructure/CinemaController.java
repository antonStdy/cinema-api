package com.cinema.main.cinema.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.cinema.domain.CinemaService;
import com.cinema.main.cinema.domain.dto.command.CinemaCreationCommand;
import com.cinema.main.cinema.domain.dto.view.SavedCinemaId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<SavedCinemaId> create(CinemaCreationCommand cinemaCreationCommand) {
        SavedCinemaId id = cinemaService.create(cinemaCreationCommand);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cinema> get(@PathVariable String id) {
        ResponseEntity<Cinema> response = cinemaService.getById(new CinemaId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        return  response;
    }

}
