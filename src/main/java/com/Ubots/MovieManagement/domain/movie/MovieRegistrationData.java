package com.Ubots.MovieManagement.domain.movie;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

public record MovieRegistrationData(
        @NotNull
        String name,
        Integer movieReview) {
}
