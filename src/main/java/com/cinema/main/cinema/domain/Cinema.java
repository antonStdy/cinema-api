package com.cinema.main.cinema.domain;

import com.cinema.main.cinema.domain.location.Location;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@ToString
@Getter
public class Cinema {
    private final  CinemaId id;
    private final Location location;
    private final CompanyInfo companyInfo;
}
