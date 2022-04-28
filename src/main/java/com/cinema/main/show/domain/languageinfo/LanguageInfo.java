package com.cinema.main.show.domain.languageinfo;

import lombok.Value;

import java.util.List;

@Value
public class LanguageInfo {
    Language primaryLanguage;
    List<Language> subtitles;
}
