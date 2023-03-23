package com.Ubots.MovieManagement.controller;

import com.Ubots.MovieManagement.domain.movie.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @Transactional
    public ResponseEntity<MovieData> movieRegistration(@RequestBody @Valid MovieRegistrationData movieRegistrationData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.movieRegistration(movieRegistrationData));
    }

    @GetMapping("/id")
    public ResponseEntity<MovieData> getMovie(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieData>> listMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.listMovie());
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateMovie(@RequestBody @Valid MovieUpdateData movieUpdateData) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieUpdateData));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/avaliar")
    @Transactional
    public ResponseEntity<MovieData> rateMovie(@RequestBody @Valid MovieRatingData movieRatingData) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.rateMovie(movieRatingData));
    }

    @GetMapping("/sem-avaliacao")
    public ResponseEntity<List<MovieData>> unratedMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.unratedMovies());
    }

}
