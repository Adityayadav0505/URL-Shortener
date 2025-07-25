package com.service.URL_Shortener.controller;

import com.service.URL_Shortener.model.UrlMapping;
import com.service.URL_Shortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service){
        this.service = service;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody String originalUrl, HttpServletRequest request){
        String shortCode = service.shortenUrl(originalUrl);

        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        return baseUrl + "/" + shortCode;
    }
}
