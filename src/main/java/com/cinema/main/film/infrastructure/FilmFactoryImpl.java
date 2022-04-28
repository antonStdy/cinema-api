package com.cinema.main.film.infrastructure;

import com.cinema.main.film.domain.FilmFactory;
import com.cinema.main.film.domain.dto.command.CreateFilmCommand;
import com.cinema.main.film.domain.film.BaseInfo;
import com.cinema.main.film.domain.film.Film;
import com.cinema.main.film.domain.film.FilmId;
import org.springframework.stereotype.Service;

@Service
public class FilmFactoryImpl implements FilmFactory {
    @Override
    public Film createNew(CreateFilmCommand command) {
        FilmId id = new FilmId();
        id.setId(command.getFilmName());
        BaseInfo baseInfo = createBaseInfo(command);

        return new Film(id, baseInfo);
    }

    public FilmId filmIdFromString(String id) {
        FilmId filmId = new FilmId();
        filmId.setId(id);
        return filmId;
    }

    private BaseInfo createBaseInfo(CreateFilmCommand command) {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setName(command.getFilmName());
        baseInfo.setReleaseDate(command.getFilmDate());
        return baseInfo;
    }
}
