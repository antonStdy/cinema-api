package com.cinema.main.cinema.domain;

import com.cinema.main.cinema.domain.dto.command.NewLocation;
import com.cinema.main.cinema.domain.location.Geo;

public interface GeoCodingService {
    Geo getCoordinates(NewLocation location);
}
