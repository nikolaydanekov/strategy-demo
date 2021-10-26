package com.patterns.strategy.service;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.domain.Status;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.DemoEntityRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService{
    private final DemoEntityRepository demoEntityRepository;

    private final Map<FilterByEnum, FilterStrategy> filterStrategyMap;

    public FilterServiceImpl(DemoEntityRepository demoEntityRepository){
        this.demoEntityRepository = demoEntityRepository;
        filterStrategyMap = new HashMap<>();
        filterStrategyMap.put(FilterByEnum.NAME, (demoEntity, value) -> demoEntity.getName().equals(value));
        filterStrategyMap.put(FilterByEnum.AMOUNT, (demoEntity, value) -> demoEntity.getAmount().equals(Long.valueOf(value)));
        filterStrategyMap.put(FilterByEnum.STATUS, (demoEntity, value) -> demoEntity.getStatus().equals(Status.valueOf(value)));
    }

    @Override
    public List<DemoEntity> filterEntities(FilterByEnum filterBy, String filterValue) {
        return filterDemoCollection(demoEntityRepository.getAllEntities(), filterStrategyMap.get(filterBy), filterValue);
    }

    private List<DemoEntity> filterDemoCollection(Collection<DemoEntity> fullList, FilterStrategy filterStrategy, String value){
        return fullList.stream()
                .filter(demoEntity -> filterStrategy.shouldFilter(demoEntity, value))
                .collect(Collectors.toList());
    }
}
