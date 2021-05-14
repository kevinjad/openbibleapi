package io.kevinjad.openbibleapi.services.searchservice;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.repositories.KJV_BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KJV_SearchService {
    @Autowired
    private KJV_BibleRepository kjv_bibleRepository;

    public List<Verse> searchVerseByPhrase(String versePhrase){
        List<Verse> verses = kjv_bibleRepository.searchVerses(versePhrase);
        return verses;
    }
}
