package com.Ubots.MovieManagement.domain.movie;

import jakarta.validation.constraints.NotNull;

public record MovieRatingData(
        @NotNull
        Long id,
        int movieReview) {
}
