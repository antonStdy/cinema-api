package com.cinema.main.cinema.infrastructure;

import com.cinema.main.cinema.domain.*;
import com.cinema.main.cinema.domain.dto.command.CinemaCreationCommand;
import com.cinema.main.cinema.domain.location.Geo;
import com.cinema.main.cinema.domain.GeoCodingService;
import com.cinema.main.cinema.domain.location.Location;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CinemaFactoryImpl implements CinemaFactory {

    private final GeoCodingService geoCodingService;


    public Cinema createWithLocationCoordinates(CinemaCreationCommand command) {
        CompanyInfo companyInfo = new CompanyInfo(command.getCompanyName(),
                command.getCompanyDescription());
        CinemaId id = createCinemaId(command);
        Location location = getLocation(command);
        return new Cinema(id, location, companyInfo);
    }

    private Location getLocation(CinemaCreationCommand command) {
        String city = command.getLocation().getCity();
        String countryCode = command.getLocation().getCountryCode();
        String address = command.getLocation().getAddress();
        Geo geo = geoCodingService
                .getCoordinates(command.getLocation());
        return new Location(city, countryCode, address, geo);
    }


    private CinemaId createCinemaId(CinemaCreationCommand command) {
        String id = command.getCompanyName() + command.getLocation().getAddress();
        id = id.toLowerCase().replaceAll("[ \n\r\t]", "");
        CinemaId cinemaId = new CinemaId();
        cinemaId.setId(id);
        return cinemaId;
    }
}
