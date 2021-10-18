package com.patterns.strategy.controller;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.dto.FilterByEnum;
import com.patterns.strategy.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DemoRestController {

    private final FilterService filterService;

    @GetMapping(value = "/demo", produces = "application/json")
    public @ResponseBody
    List<DemoEntity> getDemo(@NonNull @RequestParam("filter-by") FilterByEnum filterBy, @NonNull @RequestParam("filter-value") String filterValue){
        return filterService.filterEntities(filterBy, filterValue);
    }
}
