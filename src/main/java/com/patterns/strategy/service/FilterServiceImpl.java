package com.patterns.strategy.service;

import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.VideoGameRepository;
import com.patterns.strategy.service.strategy.FilterStrategy;
import com.patterns.strategy.service.strategy.GenreFilterStrategy;
import com.patterns.strategy.service.strategy.PriceGreaterThanFilterStrategy;
import com.patterns.strategy.service.strategy.PriceLowerThanFilterStrategy;
import com.patterns.strategy.service.strategy.RatingGreaterThanFilterStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService{
    private final VideoGameRepository videoGameRepository;

    private final Map<FilterByEnum, FilterStrategy> filterStrategyMap;

    public FilterServiceImpl(VideoGameRepository demoEntityRepository){
        this.videoGameRepository = demoEntityRepository;
        filterStrategyMap = new EnumMap<>(FilterByEnum.class);
        filterStrategyMap.put(FilterByEnum.PRICE_GREATER_THAN, new PriceGreaterThanFilterStrategy());
        filterStrategyMap.put(FilterByEnum.PRICE_LOWER_THAN, new PriceLowerThanFilterStrategy());
        filterStrategyMap.put(FilterByEnum.GENRE, new GenreFilterStrategy());
        filterStrategyMap.put(FilterByEnum.RATING_GRATER_THAN, new RatingGreaterThanFilterStrategy());
    }

    @Override
    public List<VideoGame> filterEntities(FilterByEnum filterBy, String filterValue) {
        return filterDemoCollection(videoGameRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<VideoGame> filterDemoCollection(Collection<VideoGame> fullList, FilterStrategy filterStrategy, String value){
        List<VideoGame> result = new ArrayList<>();
        for(VideoGame videoGame: fullList){
            if(filterStrategy.shouldInclude(videoGame, value)){
                result.add(videoGame);
            }
        }
        return result;
    }

}
