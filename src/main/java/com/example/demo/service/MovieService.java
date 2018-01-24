package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;
import com.example.demo.repoistory.MovieRepository;

/**
 * Created by Nasir on 12-09-2015.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }

    public List<Movie> findByDirector(Director director) {
        return movieRepository.findByDirector(director);
    }

}
