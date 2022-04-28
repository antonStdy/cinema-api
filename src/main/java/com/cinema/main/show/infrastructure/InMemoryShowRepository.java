package com.cinema.main.show.infrastructure;

import com.cinema.main.show.ShowRepository;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class InMemoryShowRepository implements ShowRepository {

    private final Map<ShowId, Show> shows = new HashMap<>();

    @Override
    public void save(Show show) {
        shows.put(show.getId(), show);
        log.info("Saved show: {}", show);
    }
}
