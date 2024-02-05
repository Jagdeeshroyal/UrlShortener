package com.jagadeesh.url_shortener.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URL {
    private String originalURL;
    private String shortenURL;
}
