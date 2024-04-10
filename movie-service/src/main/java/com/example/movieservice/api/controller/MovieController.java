package com.example.movieservice.api.controller;

import com.example.movieservice.api.service.MovieService;
import com.example.movieservice.domain.model.Movie;
import com.example.movieservice.queue.MovieSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private final MovieService movieService;
	private final MovieSender movieSender;

	public MovieController(MovieService movieService, MovieSender movieSender) {
		this.movieService = movieService;
		this.movieSender = movieSender;
	}

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		List<Movie> movies = movieService.findByGenre(genre);
		return ResponseEntity.ok().body(movies);
	}

	@PostMapping("/save")
	ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		Movie savedMovie = movieService.save(movie);
		movieSender.sendMovie(savedMovie);

		return ResponseEntity.ok().body(savedMovie);
	}
}
