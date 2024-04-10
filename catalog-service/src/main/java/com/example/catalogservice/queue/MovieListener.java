package com.example.catalogservice.queue;

import com.example.catalogservice.model.Movie;
import com.example.catalogservice.repository.IMovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
    private final IMovieRepository movieRepository;

    @Autowired
    public MovieListener(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RabbitListener(queues = "${queue.movie.name}")
    public void receive(String movieJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Movie movie = objectMapper.readValue(movieJson, Movie.class);

            movieRepository.save(movie);

            System.out.println("Película guardada en la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
