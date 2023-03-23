package com.Ubots.MovieManagement.domain.movie;

import jakarta.validation.constraints.NotNull;

public record MovieUpdateData(
        @NotNull
        Long id,
        String name,
        Integer movieReview) {
}
