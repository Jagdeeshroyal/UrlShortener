package com.jagadeesh.url_shortener.service;

import com.google.common.hash.Hashing;
import com.jagadeesh.url_shortener.exception.UrlNotFoundException;
import com.jagadeesh.url_shortener.repository.UrlRepository;
import com.jagadeesh.url_shortener.model.Url;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepo;

    public Url generateUrl(String originalUrl) {
        if (!urlValidated(originalUrl)) throw new UrlNotFoundException("Url Not found");
        String shortUrl = Hashing.murmur3_32_fixed()
                .hashString(originalUrl, Charset.defaultCharset()).toString();

        Url url = Url.builder()
                .originalUrl(originalUrl)
                .shortenUrl(shortUrl)
                .build();

        url = urlRepo.save(url);
        return url;
    }

    public boolean urlValidated(String url) {
        return UrlValidator.getInstance().isValid(url);
    }

    public String getOriginalUrl(String url) {
        Optional<Url> optUrl = urlRepo.findFirstByShortenUrl(url);
        return optUrl.isPresent() ? optUrl.get().getOriginalUrl() : "Please provide a valid input :(";
    }
}
