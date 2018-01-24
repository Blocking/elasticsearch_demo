package com.example.demo.repoistory;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;

/**
 * Created by Nasir on 12-09-2015.
 */
@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {

    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double start, Double end);
    List<Movie> findByDirector(Director director);
}
