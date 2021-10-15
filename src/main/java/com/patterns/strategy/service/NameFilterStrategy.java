package com.patterns.strategy.service;


import com.patterns.strategy.domain.DemoEntity;

public class NameFilterStrategy implements  FilterStrategy{
    @Override
    public boolean shouldFilter(DemoEntity demoEntity, String value) {
        return demoEntity.getAmount().equals(Long.valueOf(value));
    }
}
