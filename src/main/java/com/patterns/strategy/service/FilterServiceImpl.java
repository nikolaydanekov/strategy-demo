package com.patterns.strategy.service;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.DemoEntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return filterDemoList(demoEntityRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<DemoEntity> filterDemoList(List<DemoEntity> fullList, FilterStrategy filterStrategy, String value){
        List<DemoEntity> result = new ArrayList<>();
        for(DemoEntity demoEntity: fullList){
            if(!filterStrategy.shouldFilter(demoEntity, value)){
                result.add(demoEntity);
            }
        }
        return result;
    }
}