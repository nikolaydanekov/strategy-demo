package com.patterns.strategy.service.strategy;

import com.patterns.strategy.domain.VideoGame;

public interface FilterStrategy {
    boolean shouldInclude(VideoGame videoGame, String value);
}
