package com.patterns.strategy.service.strategy;

import com.patterns.strategy.domain.Genre;
import com.patterns.strategy.domain.VideoGame;

public class GenreFilterStrategy implements  FilterStrategy{
    @Override
    public boolean shouldInclude(VideoGame videoGame, String value) {
        return videoGame.getGenres().contains(Genre.valueOf(value));
    }
}
