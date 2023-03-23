package com.Ubots.MovieManagement.domain.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieData movieRegistration(MovieRegistrationData movieRegistrationData) {
        Movie movie = new Movie(movieRegistrationData);

        movieRepository.save(movie);

        return new MovieData(movie);
    }

    public MovieData getMovie(Long id) {
        Movie movie = movieRepository.getReferenceById(id);

        return new MovieData(movie);
    }

    public MovieData updateMovie(MovieUpdateData movieUpdateData) {
        Movie movie = movieRepository.getReferenceById(movieUpdateData.id());
        movie.update(movieUpdateData);

        return new MovieData(movie);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.getReferenceById(id);
        movieRepository.delete(movie);
    }

    public List<MovieData> listMovie() {
        List<MovieData> movieList = movieRepository.findAll().stream().map(MovieData::new).toList();

        return movieList;
    }

    public MovieData rateMovie(MovieRatingData movieRatingData) {
        Movie movie = movieRepository.getReferenceById(movieRatingData.id());
        movie.rateMovie(movieRatingData.movieReview());
        return new MovieData(movie);
    }

    public List<MovieData> unratedMovies() {
        List<MovieData> movieList = movieRepository.findAllByMovieReviewNaoAvaliado()
                .stream().map(MovieData::new).toList();;

        return  movieList;
    }
}
