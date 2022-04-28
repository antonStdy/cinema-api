package com.cinema.main.film.infrastructure;

import com.cinema.main.film.domain.FilmFactory;
import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.BaseInfo;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FilmFactoryImpl implements FilmFactory {
    @Override
    public Film createNew(CreateFilmCommand command) {
        FilmId id = new FilmId(command.getFilmName());
        BaseInfo baseInfo = createBaseInfo(command);

        return new Film(id, baseInfo);
    }

    private BaseInfo createBaseInfo(CreateFilmCommand command) {
        return new BaseInfo(command.getFilmName(), command.getFilmDate());
    }
}
