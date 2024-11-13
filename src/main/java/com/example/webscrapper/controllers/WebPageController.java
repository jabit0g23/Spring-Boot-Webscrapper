package com.example.webscrapper.controllers;


import com.example.webscrapper.models.Webpage;
import com.example.webscrapper.repository.WebpageRepository;
import com.example.webscrapper.services.SpiderService;
import com.example.webscrapper.services.WebscrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WebPageController {

    @Autowired
    WebpageRepository repository;

    @Autowired
    WebscrapperService webscrapperService;

    @Autowired
    SpiderService spiderService;

    //ejemplo: http://localhost:8080/api/search?query=algo
    @GetMapping("/api/search")
    public List<Webpage> search(@RequestParam("query") String query){
        List<Webpage> list = new ArrayList<>();
        Iterable<Webpage> result = repository.findByText(query);

        for (Webpage webpage : result){
            list.add(webpage);
        }

        return list;
    }

    @GetMapping("/api/webscrapper")
    public void scrapeAndSave(@RequestParam("url") String url) throws IOException {
        webscrapperService.scrapeAndSave(url);
    }

    @GetMapping("/api/start")
    public void scrapeAndSave() throws IOException {
        spiderService.start();

    }
}
