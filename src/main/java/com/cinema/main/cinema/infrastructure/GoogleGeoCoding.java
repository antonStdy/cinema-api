package com.cinema.main.cinema.infrastructure;

import com.cinema.main.cinema.domain.dto.command.NewLocation;
import com.cinema.main.cinema.domain.location.Geo;
import com.cinema.main.cinema.domain.GeoCodingService;
import com.cinema.main.cinema.domain.exception.LocationNotResolvedException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleGeoCoding implements GeoCodingService {

    private final GeoApiContext geoApiContext;

    @Override
    public Geo getCoordinates(NewLocation location) {
        GeocodingResult[] results = getGeoCodingResult(location);
        GeocodingResult matchingLocation =
                getMatchingLocation(results, location);
        LatLng latLng = matchingLocation.geometry.location;
        return new Geo(latLng.lat, latLng.lng);
    }

    private GeocodingResult[] getGeoCodingResult(NewLocation location) {
        try {
            return GeocodingApi
                    .newRequest(geoApiContext)
                    .address(location.getAddress() + ", " + location.getCity())
                    .region(location.getCountryCode()).await();
        } catch (Exception e) {
            throw new LocationNotResolvedException(e, location);
        }
    }

    private GeocodingResult getMatchingLocation(
            GeocodingResult[] results, NewLocation l) {
        try {
            return results[0];
        } catch (Exception e) {
            throw new LocationNotResolvedException(e, l);
        }
    }
}
