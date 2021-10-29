package com.patterns.strategy.service;

import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.VideoGameRepository;
import com.patterns.strategy.service.strategy.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService{
    private final VideoGameRepository videoGameRepository;

    private final Map<FilterByEnum, FilterStrategy> filterStrategyMap;

    public FilterServiceImpl(VideoGameRepository demoEntityRepository){
        this.videoGameRepository = demoEntityRepository;
        filterStrategyMap = new HashMap<>();
        filterStrategyMap.put(FilterByEnum.NAME, (demoEntity, value) -> demoEntity.getName().equals(value));
        filterStrategyMap.put(FilterByEnum.AMOUNT, (demoEntity, value) -> demoEntity.getAmount().equals(Long.valueOf(value)));
        filterStrategyMap.put(FilterByEnum.STATUS, (demoEntity, value) -> demoEntity.getStatus().equals(Status.valueOf(value)));
        filterStrategyMap.put(FilterByEnum.PRICE_GREATER_THAN, new PriceGreaterThanFilterStrategy());
        filterStrategyMap.put(FilterByEnum.PRICE_LOWER_THAN, new PriceLowerThanFilterStrategy());
        filterStrategyMap.put(FilterByEnum.GENRE, new GenreFilterStrategy());
        filterStrategyMap.put(FilterByEnum.RATING_GRATER_THAN, new RatingGreaterThanFilterStrategy());
    }

    @Override
    public List<VideoGame> filterEntities(FilterByEnum filterBy, String filterValue) {
        return filterDemoCollection(videoGameRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<DemoEntity> filterDemoCollection(Collection<DemoEntity> fullList, FilterStrategy filterStrategy, String value){
        return fullList.stream()
                .filter(demoEntity -> filterStrategy.shouldFilter(demoEntity, value))
                .collect(Collectors.toList());
    }
}
