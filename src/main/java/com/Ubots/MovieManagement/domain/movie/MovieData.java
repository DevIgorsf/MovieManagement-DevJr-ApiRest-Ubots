package com.Ubots.MovieManagement.domain.movie;

public record MovieData(String name, MovieReview movieReview) {
    public MovieData(Movie movie) {
        this(movie.getName(), movie.getMovieReview());
    }
}
