package com.patterns.strategy.service;

import com.patterns.strategy.domain.DemoEntity;

public interface FilterStrategy {
    boolean shouldFilter(DemoEntity demoEntity, String value);
}