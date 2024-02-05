package com.jagadeesh.url_shortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UrlNotFoundException extends RuntimeException{
    private String message;
    public UrlNotFoundException(){
        super();
    }
    public UrlNotFoundException(String message){
        super(message);
    }


}
