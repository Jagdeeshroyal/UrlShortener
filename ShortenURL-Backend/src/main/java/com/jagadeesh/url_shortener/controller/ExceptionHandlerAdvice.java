package com.jagadeesh.url_shortener.controller;

import com.jagadeesh.url_shortener.exception.UrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = UrlNotFoundException.class)
    public ResponseEntity<Object> handleNotFound() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "FAILURE");
        return new ResponseEntity<Object>(result, HttpStatus.NOT_FOUND);
    }
}
