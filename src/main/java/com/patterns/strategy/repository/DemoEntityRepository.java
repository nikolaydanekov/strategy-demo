package com.patterns.strategy.repository;

import com.patterns.strategy.domain.DemoEntity;
import com.patterns.strategy.domain.Status;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DemoEntityRepository {
    public List<DemoEntity> getAllEntities(){
        return Arrays.asList(
                new DemoEntity("Some name", 5L, Status.ACTIVE),
                new DemoEntity("Other entity", 4L, Status.DELETED),
                new DemoEntity("Some name", 5L, Status.SUSPENDED),
                new DemoEntity("Third name", 6L, Status.ACTIVE),
                new DemoEntity("Kotka", 5L, Status.ACTIVE),
                new DemoEntity("Some name", 3L, Status.DELETED),
                new DemoEntity("Some name", 3L, Status.SUSPENDED),
                new DemoEntity("Kotka", 5L, Status.SUSPENDED),
                new DemoEntity("Some name", 15L, Status.ACTIVE));
    }
}
