package com.example.webscrapper.jobs;

import com.example.webscrapper.services.SpiderService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebscrapperJob {

    @Autowired
    private SpiderService spiderService;

    @Scheduled(cron = "0 0 4 * * *")
    public void executeJob(){
        spiderService.start();
    }
}
