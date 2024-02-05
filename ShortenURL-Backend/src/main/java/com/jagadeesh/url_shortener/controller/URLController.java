package com.jagadeesh.url_shortener.controller;

import com.jagadeesh.url_shortener.model.URL;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLController {

    @GetMapping("/{id}")
    public static String getShortenURL(@PathVariable String url){
        return "";
    }

    @PostMapping()
    public static
}
