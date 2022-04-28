package com.cinema.main.show.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.show.ShowRepository;
import com.cinema.main.show.domain.Show;
import com.cinema.main.show.domain.ShowFactory;
import com.cinema.main.show.domain.ShowId;
import com.cinema.main.show.domain.ShowService;
import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final ShowFactory showFactory;

    @Override
    public ShowId create(CreateNewShowCommand createNewShowCommand) {
        Show show = showFactory.createShow(createNewShowCommand);
        showRepository.save(show);
        return show.getId();
    }

    @Override
    public Optional<Show> getById(ShowId id) {
        return showRepository.findById(id);
    }
}
