package com.example.webscrapper.repository;

import com.example.webscrapper.models.Webpage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebpageRepository extends CrudRepository<Webpage, Integer> {

    //native SQL
    //@Query("SELECT * FROM `webpage` WHERE domain LIKE '%google%' OR W.descripcion LIKE '%google%' OR title LIKE '%google%' OR url LIKE '%google%';")
    @Query("SELECT w FROM Webpage w WHERE w.domain LIKE %:text% OR w.descripcion LIKE %:text% OR w.title LIKE %:text% OR w.url LIKE %:text% ORDER BY w.rank DESC")
    List<Webpage> findByText(@Param("text") String text);

    Webpage findByUrl(String url);


}
