package com.cinema.main.show.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.show.ShowRepository;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class InMemoryShowRepository implements ShowRepository {

    private final Map<ShowId, Show> shows = new HashMap<>();

    @Override
    public void save(Show show) {
        shows.put(show.getId(), show);
        log.info("Saved show: {}", show);
    }

    @Override
    public Optional<Show> findById(ShowId id) {
        if (shows.containsKey(id)) {
            return Optional.of(shows.get(id));
        } else {
            return Optional.empty();
        }
    }
}
