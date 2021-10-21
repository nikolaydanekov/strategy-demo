package com.patterns.strategy.service;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.domain.Status;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.DemoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{
    private final DemoEntityRepository demoEntityRepository;

    @Override
    public List<DemoEntity> filterEntities(FilterByEnum filterBy, String filterValue) {
        List<DemoEntity> filteredEntities;
        switch (filterBy){
            case NAME:
                filteredEntities = filterByName(demoEntityRepository.getAllEntities(), filterValue);
                break;
            case AMOUNT:
                filteredEntities = filterByAmount(demoEntityRepository.getAllEntities(), filterValue);
                break;
            case STATUS:
                filteredEntities = filterByStatus(demoEntityRepository.getAllEntities(), filterValue);
                break;
            default:
                filteredEntities = new ArrayList<>();
        }
        return filteredEntities;
    }

    private List<DemoEntity> filterByName(List<DemoEntity> fullList, String value){
        List<DemoEntity> result = new ArrayList<>();
        for(DemoEntity demoEntity: fullList){
            if(!demoEntity.getName().equals(value)){
                result.add(demoEntity);
            }
        }
        return result;
    }

    private List<DemoEntity> filterByAmount(List<DemoEntity> fullList, String value){
        List<DemoEntity> result = new ArrayList<>();
        for(DemoEntity demoEntity: fullList){
            if(!demoEntity.getAmount().equals(Long.valueOf(value))){
                result.add(demoEntity);
            }
        }
        return result;
    }

    private List<DemoEntity> filterByStatus(List<DemoEntity> fullList, String value){
        List<DemoEntity> result = new ArrayList<>();
        for(DemoEntity demoEntity: fullList){
            if(!demoEntity.getStatus().equals(Status.valueOf(value))){
                result.add(demoEntity);
            }
        }
        return result;
    }

}
