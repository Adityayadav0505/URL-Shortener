package com.service.URL_Shortener.controller;

import com.service.URL_Shortener.model.UrlMapping;
import com.service.URL_Shortener.model.UrlRequest;
import com.service.URL_Shortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service){
        this.service = service;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlRequest request){

        return service.shortenUrl(request.getOriginalUrl());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode){
        String originalUrl = service.getOriginalUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}
