package com.jagadeesh.url_shortener.controller;

import com.jagadeesh.url_shortener.model.Url;
import com.jagadeesh.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("url/shortner")
@CrossOrigin(origins = "*")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping
    public String getOriginalUrl(@RequestBody String url) {
        return urlService.getOriginalUrl(url);
    }

    @PostMapping
    public ResponseEntity<Object> generateShortUrl(@RequestBody String originalUrl) {
        Url url = urlService.generateUrl(originalUrl);
        Map<String, Object> result = new HashMap<>();
        result.put("status", "SUCCESS");
        result.put("url",url);
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }

}
