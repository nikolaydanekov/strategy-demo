package com.patterns.strategy.service;

import com.patterns.strategy.domain.Status;
import com.patterns.strategy.domain.DemoEntity;

public class StatusFilterStrategy implements  FilterStrategy{
    @Override
    public boolean shouldFilter(DemoEntity demoEntity, String value) {
        return demoEntity.getStatus().equals(Status.valueOf(value));
    }
}
