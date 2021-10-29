package com.patterns.strategy.service;

import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.domain.Genre;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.DemoEntityRepository;
import com.sun.jdi.FloatValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class FilterServiceImpl implements FilterService{
    private final DemoEntityRepository demoEntityRepository;

    private final Map<FilterByEnum, FilterStrategy> filterStrategyMap;

    public FilterServiceImpl(DemoEntityRepository demoEntityRepository){
        this.demoEntityRepository = demoEntityRepository;
        filterStrategyMap = new HashMap<>();
        filterStrategyMap.put(FilterByEnum.NAME, new NameFilterStrategy());
        filterStrategyMap.put(FilterByEnum.AMOUNT, new AmountFilterStrategy());
        filterStrategyMap.put(FilterByEnum.STATUS, new StatusFilterStrategy());
    }

    @Override
    public List<DemoEntity> filterEntities(FilterByEnum filterBy, String filterValue) {
        return filterDemoCollection(demoEntityRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<DemoEntity> filterDemoCollection(Collection<DemoEntity> fullList, FilterStrategy filterStrategy, String value){
        List<DemoEntity> result = new ArrayList<>();
        for(DemoEntity demoEntity: fullList){
            if(!filterStrategy.shouldFilter(demoEntity, value)){
                result.add(demoEntity);
            }
        }
        return result;
    }

}
