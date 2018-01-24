package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by nasir on 14/11/17.
 */
@Slf4j
@RestController
public class MovieResource {

    private MovieService movieService;

    @Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody  Movie newMovie) {
        Movie savedMovie = movieService.addMovie(newMovie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(savedMovie.getId()).toUri();
        return ResponseEntity.ok(savedMovie).created(location).build();
    }

    @DeleteMapping("/movie/{id}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/movie/get-by-name/{name}")
    public ResponseEntity<List<Movie>> findMovieByName(@PathVariable("name") String movieName) {
        List<Movie> fetchedMovie = movieService.getByName(movieName);
        return ResponseEntity.ok(fetchedMovie);
    }
}
