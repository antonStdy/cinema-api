package com.cinema.main.show.infrastructure;

import com.cinema.main.cinema.domain.CinemaId;
import com.cinema.main.film.domain.film.FilmId;
import com.cinema.main.show.domain.*;
import com.cinema.main.show.domain.dto.PriceDTO;
import com.cinema.main.show.domain.dto.command.CreateNewShowCommand;
import com.cinema.main.show.domain.languageinfo.Language;
import com.cinema.main.show.domain.languageinfo.LanguageInfo;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowFactoryImpl implements ShowFactory {
    public Show createShow(CreateNewShowCommand createNewShowCommand) {
        ShowId id = new ShowId();
        id.setId(getId());
        CinemaId cinemaId = createNewShowCommand.getCinemaId();
        FilmId filmId = createNewShowCommand.getFilmId();
        Date date = createNewShowCommand.getDate();
        List<Price> prices = createNewShowCommand.getPrices()
                .stream().map(this::priceDTOToPrice)
                .collect(Collectors.toList());
        String sourceUrl = createNewShowCommand.getSourceUrl();
        LanguageInfo languageInfo = createLanguageInfo(
                createNewShowCommand.getPrimaryLanguage(),
                createNewShowCommand.getSubtitlesLanguages());

        return new Show(id, cinemaId, filmId, date, prices, languageInfo, sourceUrl);
    }

    private LanguageInfo createLanguageInfo(String primaryStr, List<String> subtitlesStr) {
        Language primary = new Language(primaryStr);
        List<Language> subtitles = new ArrayList<>();
        subtitlesStr.forEach(s -> subtitles.add(new Language(s)));

        return new LanguageInfo(primary, subtitles);
    }

    private Price priceDTOToPrice(PriceDTO priceDTO) {
        return new Price(priceDTO.getName(), priceDTO.getPrice(), priceDTO.getAdditionalInfo());
    }

    private String getId() {
        return Long.toString(new Random().nextLong(), 10);
    }
}
