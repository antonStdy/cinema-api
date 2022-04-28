package com.cinema.main.show.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
public class Price {
    private final String name;
    private final double price;
    private String additionalInfo;

    public boolean hasAdditionalInfo() {
        return additionalInfo != null;
    }
}
