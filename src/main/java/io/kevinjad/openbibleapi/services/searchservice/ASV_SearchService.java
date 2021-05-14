package io.kevinjad.openbibleapi.services.searchservice;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.repositories.ASV_BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ASV_SearchService {
    @Autowired
    private ASV_BibleRepository asv_bibleRepository;

    public List<Verse> searchVerseByPhrase(String versePhrase){
        List<Verse> verses = asv_bibleRepository.searchVerses(versePhrase);
        return verses;
    }
}
