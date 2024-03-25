package com.example.movieservice.domain.data;

import com.example.movieservice.domain.model.Movie;
import com.example.movieservice.domain.repository.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private MovieRepository repository;

	public DataLoader (MovieRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run (ApplicationArguments args) throws Exception {
		repository.save(new Movie(1L, "Djavan", "MPB", "what"));
		repository.save(new Movie(2L, "Kevinho", "Funk", "what"));
		repository.save(new Movie(3L, "Slipknot", "Rock", "what"));
		repository.save(new Movie(4L, "Anitta", "Pop", "what"));
		repository.save(new Movie(5L, "Djonga", "Hip Hop", "what"));
		repository.save(new Movie(6L, "MD Chefe", "Trap", "what"));
		repository.save(new Movie(7L, "Alok", "Eletronica", "what"));
		repository.save(new Movie(8L, "Ivete Sangalo", "Axé", "what"));
	}
}
