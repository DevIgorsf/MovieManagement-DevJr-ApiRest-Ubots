package com.Ubots.MovieManagement.domain.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieReview movieReview;

    public Movie(MovieRegistrationData movieRegistrationData) {
        this.name = movieRegistrationData.name();
        this.movieReview = MovieReview.NAO_AVALIADO;
    }
}
