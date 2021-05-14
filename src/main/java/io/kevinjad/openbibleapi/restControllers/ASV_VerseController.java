package io.kevinjad.openbibleapi.restControllers;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.entities.response.VerseBox;
import io.kevinjad.openbibleapi.services.searchservice.ASV_SearchService;
import io.kevinjad.openbibleapi.services.VerseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bible/verse/asv")
public class ASV_VerseController {
    @Autowired
    private VerseService verseService;
    @Autowired
    private ASV_SearchService asv_searchService;

    @RequestMapping("{id}")
    public VerseBox getVerseASV(@PathVariable("id") Integer id){

        Verse verse = verseService.getasvVerse(id);
        List<Verse> verseList = new ArrayList<>();
        verseList.add(verse);

        VerseBox verseBox = new VerseBox("asv",verseList);
        return verseBox;
    }

    @RequestMapping("list")
    public VerseBox getVerseListASV(@RequestParam(name = "id1") Integer id1, @RequestParam(name = "id2") Integer id2){
        List<Verse> verseList = verseService.getasvVerseList(id1,id2);
        VerseBox verseBox = new VerseBox("asv",verseList);
        return verseBox;
    }

    @RequestMapping("search")
    public VerseBox searchVerse(@RequestParam(name = "versePhrase") String versePhrase){
        List<Verse> verseList = asv_searchService.searchVerseByPhrase(versePhrase);
        VerseBox verseBox = new VerseBox("asv",verseList);
        return verseBox;
    }
}
