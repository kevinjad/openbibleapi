package io.kevinjad.openbibleapi.restControllers;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.entities.response.VerseBox;
import io.kevinjad.openbibleapi.services.VerseService;
import io.kevinjad.openbibleapi.services.searchservice.YLT_SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bible/verse/ylt")
public class YLT_VerseController {

    @Autowired
    private VerseService verseService;
    @Autowired
    private YLT_SearchService ylt_searchService;

    @RequestMapping("{id}")
    public VerseBox getVerseYLT(@PathVariable("id") Integer id){

        Verse verse = verseService.getyltVerse(id);
        List<Verse> verseList = new ArrayList<>();
        verseList.add(verse);

        VerseBox verseBox = new VerseBox("ylt",verseList);
        return verseBox;
    }

    @RequestMapping("list")
    public VerseBox getVerseListYLT(@RequestParam(name = "id1") Integer id1, @RequestParam(name = "id2") Integer id2){
        List<Verse> verseList = verseService.getyltVerseList(id1,id2);
        VerseBox verseBox = new VerseBox("ylt",verseList);
        return verseBox;
    }

    @RequestMapping("search")
    public VerseBox searchVerse(@RequestParam(name = "versePhrase") String versePhrase){
        List<Verse> verseList = ylt_searchService.searchVerseByPhrase(versePhrase);
        VerseBox verseBox = new VerseBox("ylt",verseList);
        return verseBox;
    }
}
