package com.cinema.main.show;

import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowId;

import java.util.Optional;

public interface ShowRepository {
    void save(Show show);

    Optional<Show> findById(ShowId id);
}
