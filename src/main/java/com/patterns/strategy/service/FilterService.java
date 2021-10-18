package com.patterns.strategy.service;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.dto.FilterByEnum;

import java.util.List;

public interface FilterService {
    List<DemoEntity> filterEntities(FilterByEnum filterBy, String filterValue);
}
