package io.kevinjad.openbibleapi.entities.response;

import io.kevinjad.openbibleapi.entities.Verse;

import java.util.List;

public class VerseBox {
    private String bibleTranslation;

    private List<Verse> verseList;

    public VerseBox(String bibleTranslation, List<Verse> verseList) {
        this.bibleTranslation = bibleTranslation;
        this.verseList = verseList;
    }

    public String getBibleTranslation() {
        return bibleTranslation;
    }

    public void setBibleTranslation(String bibleTranslation) {
        this.bibleTranslation = bibleTranslation;
    }

    public List<Verse> getVerseList() {
        return verseList;
    }

    public void setVerseList(List<Verse> verseList) {
        this.verseList = verseList;
    }
}
