package io.kevinjad.openbibleapi.restControllers;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.entities.response.VerseBox;
import io.kevinjad.openbibleapi.services.searchservice.KJV_SearchService;
import io.kevinjad.openbibleapi.services.VerseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bible/verse/kjv")
public class KJV_VerseController {

    @Autowired
    private VerseService verseService;

    @Autowired
    private KJV_SearchService kjv_searchService;
    
    @RequestMapping("{id}")
    public VerseBox getVerseKJV(@PathVariable("id") Integer id){

        Verse verse = verseService.getkjvVerse(id);
        List<Verse> verseList = new ArrayList<>();
        verseList.add(verse);

        VerseBox verseBox = new VerseBox("kjv",verseList);
        return verseBox;
    }

    @RequestMapping("list")
    public VerseBox getVerseListKJV(@RequestParam(name = "id1") Integer id1,@RequestParam(name = "id2") Integer id2){
        List<Verse> verseList = verseService.getkjvVerseList(id1,id2);
        VerseBox verseBox = new VerseBox("kjv",verseList);
        return verseBox;
    }

    @RequestMapping("search")
    public VerseBox searchVerse(@RequestParam(name = "versePhrase") String versePhrase){
        List<Verse> verseList = kjv_searchService.searchVerseByPhrase(versePhrase);
        VerseBox verseBox = new VerseBox("kjv",verseList);
        return verseBox;
    }
}
