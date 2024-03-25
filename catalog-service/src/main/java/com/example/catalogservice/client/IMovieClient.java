package com.example.catalogservice.client;


import com.example.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {

    @GetMapping("/catalog/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);

}
