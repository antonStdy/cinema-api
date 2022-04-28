package com.cinema.main.cinema.domain.exception;

import com.cinema.main.cinema.domain.dto.command.NewLocation;

public class LocationNotResolvedException extends RuntimeException {
    public LocationNotResolvedException(Exception e, NewLocation location) {
        super("Cannot resolve location : " + location.toString(), e);
    }
    public LocationNotResolvedException(NewLocation location) {
        super("Cannot resolve location : " + location.toString());
    }
}
