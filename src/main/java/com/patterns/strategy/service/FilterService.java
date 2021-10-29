package com.patterns.strategy.service;

import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.dto.FilterByEnum;

import java.util.List;

public interface FilterService {
    List<VideoGame> filterEntities(FilterByEnum filterBy, String filterValue);
}
