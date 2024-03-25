package com.example.catalogservice.controller;

import com.example.catalogservice.client.IMovieClient;
import com.example.catalogservice.model.Movie;
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

    @GetMapping("playlist/{genre}")
    public ResponseEntity<List<Movie>> getPlaylistByGenre (@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }


}
