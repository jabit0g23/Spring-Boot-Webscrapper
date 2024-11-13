package com.example.webscrapper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SpiderService {

    @Autowired
    private WebscrapperService webscrapperService;

    public void start() {
        String initialLink = "https://elpais.com/hemeroteca/elpais/portadas/2024/05/14/";
        scrapeLinksAndSave(initialLink);
    }

    public void scrapeLinksAndSave(String url) {
        String initialLink = "https://elpais.com";
        List<String> links = webscrapperService.getAllLinks(initialLink);
        links.stream().parallel().forEach(link -> {
            try {
                webscrapperService.scrapeAndSave(link);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scrapeLinksAndSave(url);
        });
    }
}
