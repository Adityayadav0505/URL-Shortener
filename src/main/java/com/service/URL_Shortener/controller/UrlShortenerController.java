package com.service.URL_Shortener.controller;

import com.service.URL_Shortener.model.UrlRequest;
import com.service.URL_Shortener.service.UrlShortenerService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @RateLimiter(name = "shortenUrlLimiter")
    public String shorten(@RequestBody UrlRequest request){

        return service.shortenUrl(request.getOriginalUrl());
    }

    @GetMapping("/{shortCode}")
    @RateLimiter(name = "redirectUrlLimiter")
    public ResponseEntity<?> redirect(@PathVariable String shortCode){
        String originalUrl = service.getOriginalUrl(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
