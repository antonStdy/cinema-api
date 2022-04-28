package com.cinema.main.cinema.infrastructure;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleGeoCodingConfig {

    @Value("${location.googleGeoCoding.apiKey}")
    private String geoApiKey;

    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(geoApiKey)
                .build();
    }
}
