package com.patterns.strategy.service.strategy;

import com.patterns.strategy.domain.VideoGame;

import java.math.BigDecimal;

public class PriceGreaterThanFilterStrategy implements  FilterStrategy{
    @Override
    public boolean shouldInclude(VideoGame videoGame, String value) {
        return videoGame.getPrice().compareTo(new BigDecimal(value)) >= 0;
    }
}
