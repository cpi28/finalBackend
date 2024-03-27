package com.example.catalogservice.client;

import com.example.catalogservice.model.Movie;
import com.example.catalogservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service")
public interface ISerieClient {

    @GetMapping("/catalog/serie/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre);
}
