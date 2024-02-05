package com.jagadeesh.url_shortener.repository;

import com.jagadeesh.url_shortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url,Integer> {

    Optional<Url> findFirstByShortenUrl(String shortenUrl);
}
