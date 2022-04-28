package com.cinema.main.show.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;
import com.cinema.main.show.domain.ShowService;
import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/show")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowId> create(@RequestBody CreateNewShowCommand command) {
        ShowId id = showService.create(command);
        return ResponseEntity.ok(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Show> get(@PathVariable String id) {
        ShowId showId = new ShowId();
        showId.setId(id);
        ResponseEntity<Show> response = showService.getById(showId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        return  response;
    }
}
