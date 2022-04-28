package com.cinema.main.cinema.domain.dto.command;

import lombok.Data;

@Data
public class CinemaCreationCommand {
    private String companyName;
    private String companyDescription;
    private NewLocation location;
}
