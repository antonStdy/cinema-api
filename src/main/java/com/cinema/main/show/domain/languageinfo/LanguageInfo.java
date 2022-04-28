package com.cinema.main.show.domain.languageinfo;

import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class LanguageInfo {
    private Language primaryLanguage;

    private List<Language> subtitles;

    public LanguageInfo(Language primaryLanguage, List<Language> subtitles) {
        this.primaryLanguage = primaryLanguage;
        this.subtitles = subtitles;
    }
}
