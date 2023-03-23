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
        if(movieRegistrationData.raviewMovie() != null) {
            rateMovie(movieRegistrationData.raviewMovie());
        } else {
            this.movieReview = MovieReview.NAO_AVALIADO;
        }
    }

    public void update(MovieUpdateData movieUpdateData) {
        if (movieUpdateData.name() != null) {
            this.name = movieUpdateData.name();
        }
        if (movieUpdateData.movieReview() != null) {
            rateMovie(movieUpdateData.movieReview());
        }
    }

    public void rateMovie(int raviewMovie) {
        switch (raviewMovie) {
            case 1:
                this.movieReview = MovieReview.RUIM;
                break;
            case 2:
                this.movieReview = MovieReview.OK;
                break;
            case 3:
                this.movieReview = MovieReview.BOM;
                break;
            case 4:
                this.movieReview = MovieReview.OTIMO;
                break;
            case 5:
                this.movieReview = MovieReview.UAU;
                break;
            default:
                this.movieReview = MovieReview.NAO_AVALIADO;
        }
    }
}
