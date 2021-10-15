package com.example.demo.service;

import com.example.demo.domain.DemoEntity;
import com.example.demo.domain.Status;
import com.example.demo.dto.FilterByEnum;
import com.example.demo.repository.DemoEntityRepository;
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
        List<DemoEntity> filteredEntities = new ArrayList<>();
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
