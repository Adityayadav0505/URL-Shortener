package com.service.URL_Shortener.controller;

import com.service.URL_Shortener.model.UrlMapping;
import com.service.URL_Shortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service){
        this.service = service;
    }

    @GetMapping("/shorten")
    public String shorten(){
        return service.shortenUrl("https://mail.google.com");
    }
}
