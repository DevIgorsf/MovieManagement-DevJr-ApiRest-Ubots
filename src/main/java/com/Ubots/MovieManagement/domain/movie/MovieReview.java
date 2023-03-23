package com.Ubots.MovieManagement.domain.movie;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MovieReview {

    NAO_AVALIADO(0, "Sem avaliação"),
    RUIM(1, "Ruim"),
    OK(2, "Ok"),
    BOM(3, "Bom"),
    OTIMO(4, "Ótimo"),
    UAU(5, "Uau");

    private int key;
    private String description;

    MovieReview(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static final Map<Integer, MovieReview> movieReviewMap = new HashMap<Integer, MovieReview>();
    static {
        for (MovieReview movieReview : EnumSet.allOf(MovieReview.class)) {
            movieReviewMap.put(movieReview.getKey(), movieReview);
        }
    }

    public static MovieReview get(String string) {
        return movieReviewMap.get(string);
    }
}
