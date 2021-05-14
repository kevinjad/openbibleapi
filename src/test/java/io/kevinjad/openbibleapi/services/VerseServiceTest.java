package io.kevinjad.openbibleapi.services;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.repositories.ASV_BibleRepository;
import io.kevinjad.openbibleapi.repositories.KJV_BibleRepository;
import io.kevinjad.openbibleapi.repositories.YLT_BibleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerseServiceTest {

    private VerseService verseService;

    @Mock
    private KJV_BibleRepository kjv_bibleRepository;
    @Mock
    private ASV_BibleRepository asv_bibleRepository;
    @Mock
    private YLT_BibleRepository ylt_bibleRepository;

    @BeforeEach
    void setup(){
        verseService = new VerseService(kjv_bibleRepository,asv_bibleRepository,ylt_bibleRepository);
    }

    @Test
    @DisplayName("Testing getkjvVerse")
    void getkjvVerse() {
        Verse verse = new Verse();
        int id = 001001001;
        when(kjv_bibleRepository.findVerseById(id)).thenReturn(verse);
        Verse verseToAssert = verseService.getkjvVerse(id);
        assertEquals(verse,verseToAssert);
    }

    @Test
    @DisplayName("Testing getkjvVerseList")
    void getkjvVerseList() {
        List<Verse> verseListExpected = new ArrayList<>();
        Verse verse1 = new Verse();
        Verse verse2 = new Verse();
        verseListExpected.add(verse1);
        verseListExpected.add(verse2);

        int id1=001001001;
        int id2=001001002;
        when(kjv_bibleRepository.findListOfVerses(id1,id2)).thenReturn(verseListExpected);
        List<Verse> verseListActual = verseService.getkjvVerseList(id1,id2);
        assertEquals(verseListExpected,verseListActual);
    }

    @Test
    @DisplayName("Testing getasvVerse")
    void getasvVerse() {
        Verse verse = new Verse();
        int id = 001001001;
        when(asv_bibleRepository.findVerseById(id)).thenReturn(verse);
        Verse verseToAssert = verseService.getasvVerse(id);
        assertEquals(verse,verseToAssert);
    }

    @Test
    @DisplayName("Testing getasvVerseList")
    void getasvVerseList() {
        List<Verse> verseListExpected = new ArrayList<>();
        Verse verse1 = new Verse();
        Verse verse2 = new Verse();
        verseListExpected.add(verse1);
        verseListExpected.add(verse2);

        int id1=001001001;
        int id2=001001002;
        when(asv_bibleRepository.findListOfVerses(id1,id2)).thenReturn(verseListExpected);
        List<Verse> verseListActual = verseService.getasvVerseList(id1,id2);
        assertEquals(verseListExpected,verseListActual);
    }

    @Test
    @DisplayName("Testing getyltVerse")
    void getyltVerse() {
        Verse verse = new Verse();
        int id = 001001001;
        when(ylt_bibleRepository.findVerseById(id)).thenReturn(verse);
        Verse verseToAssert = verseService.getyltVerse(id);
        assertEquals(verse,verseToAssert);
    }

    @Test
    @DisplayName("Testing getyltVerseList")
    void getyltVerseList() {
        List<Verse> verseListExpected = new ArrayList<>();
        Verse verse1 = new Verse();
        Verse verse2 = new Verse();
        verseListExpected.add(verse1);
        verseListExpected.add(verse2);

        int id1=001001001;
        int id2=001001002;
        when(ylt_bibleRepository.findListOfVerses(id1,id2)).thenReturn(verseListExpected);
        List<Verse> verseListActual = verseService.getyltVerseList(id1,id2);
        assertEquals(verseListExpected,verseListActual);
    }
}