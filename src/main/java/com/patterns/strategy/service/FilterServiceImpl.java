package com.patterns.strategy.service;

import com.patterns.strategy.domain.Genre;
import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.VideoGameRepository;
import com.patterns.strategy.service.strategy.FilterStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService{
    private final VideoGameRepository videoGameRepository;

    private final Map<FilterByEnum, FilterStrategy> filterStrategyMap;

    public FilterServiceImpl(VideoGameRepository videoGameRepository){
        this.videoGameRepository = videoGameRepository;
        filterStrategyMap = new HashMap<>();
        filterStrategyMap.put(FilterByEnum.PRICE_GREATER_THAN, (videoGame, value) -> videoGame.getPrice().compareTo(new BigDecimal(value)) >= 0);
        filterStrategyMap.put(FilterByEnum.PRICE_LOWER_THAN, (videoGame, value) -> videoGame.getPrice().compareTo(new BigDecimal(value)) <= 0);
        filterStrategyMap.put(FilterByEnum.GENRE, (videoGame, value) -> videoGame.getGenres().contains(Genre.valueOf(value)));
        filterStrategyMap.put(FilterByEnum.RATING_GRATER_THAN, (videoGame, value) -> videoGame.getRating() >= Float.parseFloat(value));
    }

    @Override
    public List<VideoGame> filterEntities(FilterByEnum filterBy, String filterValue) {
        return filterDemoCollection(videoGameRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<VideoGame> filterDemoCollection(Collection<VideoGame> fullList, FilterStrategy filterStrategy, String value){
        return fullList.stream()
                .filter(videoGame -> filterStrategy.shouldInclude(videoGame, value))
                .collect(Collectors.toList());
    }
}
