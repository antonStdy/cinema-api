package com.cinema.main.cinema.domain.dto.command;

import lombok.Data;
import lombok.Value;

@Data
public class NewLocation {
    private String city;
    private String countryCode;
    private String address;
}
