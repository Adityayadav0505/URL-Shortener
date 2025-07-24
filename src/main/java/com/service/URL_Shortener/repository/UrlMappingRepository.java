package com.service.URL_Shortener.repository;

import com.service.URL_Shortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

}
