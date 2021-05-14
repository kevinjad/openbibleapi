package io.kevinjad.openbibleapi.services.searchservice;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.repositories.YLT_BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YLT_SearchService {
    @Autowired
    private YLT_BibleRepository ylt_bibleRepository;

    public List<Verse> searchVerseByPhrase(String versePhrase){
        List<Verse> verses = ylt_bibleRepository.searchVerses(versePhrase);
        return verses;
    }
}
