package com.Ubots.MovieManagement.controller;

import com.Ubots.MovieManagement.domain.movie.MovieData;
import com.Ubots.MovieManagement.domain.movie.MovieRegistrationData;
import com.Ubots.MovieManagement.domain.movie.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @Transactional
    public ResponseEntity<MovieData> movieRegistration (@RequestBody @Valid MovieRegistrationData movieRegistrationData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.movieRegistration(movieRegistrationData));
    }
}
