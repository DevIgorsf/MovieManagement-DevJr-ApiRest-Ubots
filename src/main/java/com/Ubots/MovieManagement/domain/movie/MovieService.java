package com.Ubots.MovieManagement.domain.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public MovieData movieRegistration(MovieRegistrationData movieRegistrationData) {
        Movie movie = new Movie(movieRegistrationData);

        movieRepository.save(movie);

        return new MovieData(movie);
    }
}
