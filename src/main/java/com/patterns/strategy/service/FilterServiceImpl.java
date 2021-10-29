package com.patterns.strategy.service;

import com.patterns.strategy.domain.VideoGame;
import com.patterns.strategy.domain.Genre;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.repository.DemoEntityRepository;
import com.sun.jdi.FloatValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService{
    private final DemoEntityRepository demoEntityRepository;

    @Override
    public List<VideoGame> filterEntities(FilterByEnum filterBy, String filterValue) {
        List<VideoGame> filteredEntities;
        switch (filterBy){
            case PRICE_GREATER_THAN:
                filteredEntities = filterByPriceGreaterThan(demoEntityRepository.getAllEntities(), filterValue);
                break;
            case PRICE_LOWER_THAN:
                filteredEntities = filterByPriceLowerThan(demoEntityRepository.getAllEntities(), filterValue);
                break;
            case GENRE:
                filteredEntities = filterByGenre(demoEntityRepository.getAllEntities(), filterValue);
                break;
            case RATING_GRATER_THAN:
                filteredEntities = filterByRatingGreaterThan(demoEntityRepository.getAllEntities(), filterValue);
                break;
            default:
                filteredEntities = demoEntityRepository.getAllEntities();
        }
        return filteredEntities;
    }

    private List<VideoGame> filterByPriceGreaterThan(List<VideoGame> fullList, String value){
        List<VideoGame> result = new ArrayList<>();
        for(VideoGame videoGame : fullList){
            if(videoGame.getPrice().compareTo(BigDecimal.valueOf(Float.parseFloat(value))) >= 0){
                result.add(videoGame);
            }
        }
        return result;
    }

    private List<VideoGame> filterByPriceLowerThan(List<VideoGame> fullList, String value){
        List<VideoGame> result = new ArrayList<>();
        for(VideoGame videoGame : fullList){
            if(videoGame.getPrice().compareTo(BigDecimal.valueOf(Float.parseFloat(value))) <= 0){
                result.add(videoGame);
            }
        }
        return result;
    }

    private List<VideoGame> filterByGenre(List<VideoGame> fullList, String value){
        List<VideoGame> result = new ArrayList<>();
        for(VideoGame videoGame : fullList){
            if(videoGame.getGenres().contains(Genre.valueOf(value))){
                result.add(videoGame);
            }
        }
        return result;
    }

    private List<VideoGame> filterByRatingGreaterThan(List<VideoGame> fullList, String value){
        List<VideoGame> result = new ArrayList<>();
        for(VideoGame videoGame : fullList){
            if(videoGame.getRating() >= Float.parseFloat(value)){
                result.add(videoGame);
            }
        }
        return result;
    }

}
