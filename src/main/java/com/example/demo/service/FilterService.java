package com.example.demo.service;

import com.example.demo.domain.DemoEntity;
import com.example.demo.dto.FilterByEnum;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FilterService {
    List<DemoEntity> filterEntities(FilterByEnum filterBy, String filterValue);
}
