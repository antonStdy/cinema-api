package com.cinema.main.cinema.infrastructure;

import com.cinema.main.cinema.domain.Cinema;
import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.cinema.domain.CinemaRepository;
import com.cinema.main.cinema.domain.CompanyInfo;
import com.cinema.main.cinema.domain.location.Geo;
import com.cinema.main.cinema.domain.location.Location;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class InMemoryCinemaRepository implements CinemaRepository {

    private final Map<CinemaId, Cinema> cinemasById = new HashMap<>();

    @PostConstruct
    void initTestData() {
        save(getTestCinema());
    }

    @Override
    public void save(Cinema cinema) {
        cinemasById.put(cinema.getId(), cinema);
        log.info("Cinema saved: {}", cinema);
    }

    @Override
    public Optional<Cinema> findById(CinemaId id) {
        if (cinemasById.containsKey(id)) {
            return Optional.of(cinemasById.get(id));
        } else {
            return Optional.empty();
        }
    }

    private Cinema getTestCinema() {
        CinemaId id = new CinemaId();
        id.setId("test");
        Geo geo = new Geo(1.0, 1.0);
        Location loc = new Location("testCity", "testCountryCode", "testAddress", geo);
        CompanyInfo info = new CompanyInfo("testName", "testDescription");
        return new Cinema(id, loc, info);
    }
}
