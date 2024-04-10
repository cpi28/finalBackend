package com.example.catalogservice.controller;

import com.example.catalogservice.client.IMovieClient;
import com.example.catalogservice.client.ISerieClient;
import com.example.catalogservice.model.Catalog;
import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;
import com.example.catalogservice.repository.IMovieRepository;
import com.example.catalogservice.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    @Autowired
    private IMovieRepository iMovieRepository;

    @Autowired
    private ISerieRepository iSerieRepository;

    /*@GetMapping("catalog/movie/{genre}")
    public ResponseEntity<List<Movie>> getCatalogMovieByGenre (@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }*/
    @GetMapping("/movie/{genre}")
    ResponseEntity<Catalog> getMovieByGenre(@PathVariable String genre) {
        //String loadBalancerResponse = loadBalancer.callOtherService();
        //System.out.println("Load Balancer Response: " + loadBalancerResponse);

        List<Movie> movies = iMovieClient.getMovieByGenre(genre);
        Catalog catalog = new Catalog();
        catalog.setGenre(genre);
        catalog.setMovies(movies);
        //catalog.setLoadBalancerResponse(loadBalancerResponse);

        return ResponseEntity.ok().body(catalog);
    }

    @PostMapping("/movie/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(iMovieClient.saveMovie(movie));
    }

    /*@GetMapping("catalog/serie/{genre}")
    public ResponseEntity<List<Serie>> getCatalogSerieByGenre (@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }*/

    @PostMapping("/serie/save")
    public ResponseEntity<String> saveSerie(@RequestBody Serie serie) {
        String serieId = iSerieClient.saveSerie(serie);
        return ResponseEntity.ok().body(serieId);
    }

    @GetMapping("/serie/{genre}")
    public ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
        List<Serie> series = iSerieClient.getSerieByGenre(genre);
        return ResponseEntity.ok().body(series);
    }

    @GetMapping("/v1/movie/{genre}")
    ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = iMovieRepository.findByGenre(genre);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/v1/serie/{genre}")
    ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre) {
        List<Serie> series = iSerieRepository.findByGenre(genre);
        return ResponseEntity.ok().body(series);
    }


}
