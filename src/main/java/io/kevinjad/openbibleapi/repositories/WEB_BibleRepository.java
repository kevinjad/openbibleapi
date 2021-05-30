package io.kevinjad.openbibleapi.repositories;

import io.kevinjad.openbibleapi.entities.Verse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface WEB_BibleRepository extends Repository<Verse,Integer> {
    Verse findVerseById(Integer id);

    @Query(value = "SELECT * FROM t_web WHERE id BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Verse> findListOfVerses(Integer id1, Integer id2);

    @Query(value = "SELECT * FROM t_web WHERE t LIKE %:versePhrase%",nativeQuery = true)
    List<Verse> searchVerses(@Param("versePhrase") String versePhrase);
}
