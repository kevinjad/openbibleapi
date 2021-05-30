package io.kevinjad.openbibleapi.restControllers;

import io.kevinjad.openbibleapi.entities.Verse;
import io.kevinjad.openbibleapi.entities.response.VerseBox;
import io.kevinjad.openbibleapi.services.VerseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bible/verse/web")
public class WEB_VerseController {
    @Autowired
    private VerseService verseService;

    @RequestMapping("{id}")
    public VerseBox getVerseWEB(@PathVariable("id") Integer id){
        Verse verse = verseService.getwebVerse(id);
        List<Verse> verseList = new ArrayList<>();
        verseList.add(verse);

        VerseBox verseBox = new VerseBox("web",verseList);
        return verseBox;
    }

    @RequestMapping("list")
    public VerseBox getVerseListWEB(@RequestParam(name = "id1") Integer id1, @RequestParam(name = "id2") Integer id2){
        List<Verse> verseList = verseService.getwebVerseList(id1,id2);
        VerseBox verseBox = new VerseBox("web",verseList);
        return verseBox;
    }
}
