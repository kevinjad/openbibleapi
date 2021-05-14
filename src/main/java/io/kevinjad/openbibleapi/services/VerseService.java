package io.kevinjad.openbibleapi.services;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.repositories.ASV_BibleRepository;
import io.kevinjad.openbibleapi.repositories.KJV_BibleRepository;
import io.kevinjad.openbibleapi.repositories.YLT_BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerseService {

    private KJV_BibleRepository kjv_bibleRepository;

    private ASV_BibleRepository asv_bibleRepository;

    private YLT_BibleRepository ylt_bibleRepository;


    public Verse getkjvVerse(Integer id){
        Verse verse = kjv_bibleRepository.findVerseById(id);
        return verse;
    }

    public List<Verse> getkjvVerseList(Integer id1, Integer id2){
        List<Verse> verses = kjv_bibleRepository.findListOfVerses(id1,id2);
        return verses;
    }

    public Verse getasvVerse(Integer id){
        Verse verse = asv_bibleRepository.findVerseById(id);
        return verse;
    }

    public List<Verse> getasvVerseList(Integer id1, Integer id2){
        List<Verse> verses = asv_bibleRepository.findListOfVerses(id1,id2);
        return verses;
    }

    public Verse getyltVerse(Integer id){
        Verse verse = ylt_bibleRepository.findVerseById(id);
        return verse;
    }
    @Autowired
    public VerseService(KJV_BibleRepository kjv_bibleRepository, ASV_BibleRepository asv_bibleRepository, YLT_BibleRepository ylt_bibleRepository) {
        this.kjv_bibleRepository = kjv_bibleRepository;
        this.asv_bibleRepository = asv_bibleRepository;
        this.ylt_bibleRepository = ylt_bibleRepository;
    }

    public List<Verse> getyltVerseList(Integer id1, Integer id2){
        List<Verse> verses = ylt_bibleRepository.findListOfVerses(id1,id2);
        return verses;
    }
}
