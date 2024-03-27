package com.example.catalogservice.controller;

import com.example.catalogservice.client.IMovieClient;
import com.example.catalogservice.client.ISerieClient;
import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    @GetMapping("catalog/movie/{genre}")
    public ResponseEntity<List<Movie>> getCatalogMovieByGenre (@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }

    @GetMapping("catalog/serie/{genre}")
    public ResponseEntity<List<Serie>> getCatalogSerieByGenre (@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }


}
