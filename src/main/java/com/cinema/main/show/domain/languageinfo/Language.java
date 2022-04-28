package com.cinema.main.show.domain.languageinfo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Language {
    private String lang;

    public Language(String lang) {
        this.lang = lang;
    }
}
