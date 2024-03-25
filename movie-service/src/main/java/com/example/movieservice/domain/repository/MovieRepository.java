package com.example.movieservice.domain.repository;

import com.example.movieservice.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//	@Query("SELECT m FROM Music m WHERE m.genre = ?1")
	List<Movie> findByGenre(String genre);
}
