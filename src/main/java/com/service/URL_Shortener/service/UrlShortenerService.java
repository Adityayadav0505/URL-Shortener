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

    public String shortenUrl(String originalUrl){
        UrlMapping mapping = new UrlMapping();

        mapping.setOriginalUrl(originalUrl);
        mapping.setCreatedAt(LocalDateTime.now());

        UrlMapping saved = repository.save(mapping);

        String shortCode = encode(saved.getId());

        saved.setShortCode(shortCode);
        repository.save(saved);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"))
                .getOriginalUrl();
    }

    private String encode(Long id) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortCode = new StringBuilder();
        while (id > 0) {
            shortCode.append(chars.charAt((int)(id % 62)));
            id /= 62;
        }
        return shortCode.reverse().toString();
    }
}
