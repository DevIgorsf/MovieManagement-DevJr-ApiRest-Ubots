package com.Ubots.MovieManagement.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.movieReview = 'NAO_AVALIADO'")
    List<Movie> findAllByMovieReviewNaoAvaliado();

    boolean existsByName(String name);
}
