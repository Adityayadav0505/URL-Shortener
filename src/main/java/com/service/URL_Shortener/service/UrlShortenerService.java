package com.service.URL_Shortener.service;

import com.service.URL_Shortener.model.UrlMapping;
import com.service.URL_Shortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository repository;

    public UrlMapping shortenUrl(String originalUrl){
        UrlMapping mapping = new UrlMapping();

        mapping.setLongUrl(originalUrl);
        mapping.setCreatedAt(LocalDateTime.now());

        repository.save(mapping);

        return mapping;
    }
}
