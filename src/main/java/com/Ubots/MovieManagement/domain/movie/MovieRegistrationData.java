package com.Ubots.MovieManagement.domain.movie;

import jakarta.validation.constraints.NotNull;

public record MovieRegistrationData(
        @NotNull
        String name) {
}
