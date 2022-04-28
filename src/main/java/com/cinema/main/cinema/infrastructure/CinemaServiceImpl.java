package com.cinema.main.cinema.infrastructure;

import com.cinema.main.cinema.domain.*;
import com.cinema.main.cinema.domain.dto.command.CinemaCreationCommand;
import com.cinema.main.cinema.domain.dto.view.SavedCinemaId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl  implements CinemaService {

    private final CinemaFactory cinemaFactoryImpl;
    private final CinemaRepository cinemaRepository;

    @Override
    public SavedCinemaId create(CinemaCreationCommand cinemaCreationCommand) {
        Cinema cinema = cinemaFactoryImpl
                .createWithLocationCoordinates(cinemaCreationCommand);
        cinemaRepository.save(cinema);
        return new SavedCinemaId(cinema.getId().getId());
    }

    @Override
    public Optional<Cinema> getById(CinemaId id) {
        return cinemaRepository.findById(id);
    }
}
