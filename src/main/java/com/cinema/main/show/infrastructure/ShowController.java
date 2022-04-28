package com.cinema.main.show.infrastructure;

import com.cinema.main.show.domain.ShowId;
import com.cinema.main.show.domain.ShowService;
import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowId> create(CreateNewShowCommand command) {
        ShowId id = showService.create(command);
        return ResponseEntity.ok(id);
    }
}
