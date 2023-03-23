package com.Ubots.MovieManagement.domain.movie;

public record MovieData(Long id, String name, MovieReview movieReview) {
    public MovieData(Movie movie) {
        this(movie.getId(), movie.getName(), movie.getMovieReview());
    }
}
