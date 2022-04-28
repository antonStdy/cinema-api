package com.cinema.main.cinema.domain.location;


public class Location {
    private final String city;
    private final String countryCode;
    private final String address;
    private final Geo geo;


    public Location(String city, String countryCode, String address, Geo geo) {
        this.city = city;
        this.countryCode = countryCode;
        this.address = address;
        this.geo = geo;

    }

    public String getFullAddress() {
        return address + ", " + city;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
