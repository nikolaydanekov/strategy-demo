package com.patterns.strategy.service.strategy;

import com.patterns.strategy.domain.VideoGame;

public class RatingGreaterThanFilterStrategy implements  FilterStrategy{
    @Override
    public boolean shouldInclude(VideoGame videoGame, String value) {
        return videoGame.getRating() >= Float.parseFloat(value);
    }
}
