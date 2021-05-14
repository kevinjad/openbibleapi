package io.kevinjad.openbibleapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


import io.kevinjad.openbibleapi.entities.Verse;
import org.springframework.data.repository.query.Param;

@org.springframework.stereotype.Repository
public interface KJV_BibleRepository extends Repository<Verse,Integer>{
    Verse findVerseById(Integer id);

    @Query(value = "SELECT * FROM t_kjv WHERE id BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Verse> findListOfVerses(Integer id1, Integer id2);

    @Query(value = "SELECT * FROM t_kjv WHERE t LIKE %:versePhrase%",nativeQuery = true)
    List<Verse> searchVerses(@Param("versePhrase") String versePhrase);
}
