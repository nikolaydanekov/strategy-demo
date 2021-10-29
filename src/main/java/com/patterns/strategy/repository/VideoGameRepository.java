package com.patterns.strategy.repository;

import com.patterns.strategy.domain.VideoGame;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.patterns.strategy.domain.Genre.*;
@Component
public class VideoGameRepository {
    public List<VideoGame> getAllEntities(){
        return Arrays.asList(
                new VideoGame("God of war", BigDecimal.valueOf(69.99), Set.of(RPG, ACTION, THIRD_PERSON), 9.0f),
                new VideoGame("DnD", BigDecimal.valueOf(20), Set.of(RPG, BOARD), 8.5f),
                new VideoGame("Counter Strike", BigDecimal.valueOf(69.99), Set.of(ACTION, FIRST_PERSON_SHOOTER), 9.0f),
                new VideoGame("Super Mario", BigDecimal.valueOf(69.99), Set.of(PLATFORMER, ACTION, THIRD_PERSON), 9.5f),
                new VideoGame("Star Craft 2", BigDecimal.valueOf(69.99), Set.of(RPG, STRATEGY), 9.0f),
                new VideoGame("Goat simulator", BigDecimal.valueOf(69.99), Set.of(RPG, ACTION, SIMULATOR), 7.0f),
                new VideoGame("Some bad game", BigDecimal.valueOf(10), Set.of(RPG, ACTION, THIRD_PERSON), 4.0f),
                new VideoGame("Deadpool", BigDecimal.valueOf(30), Set.of(RPG, ACTION, THIRD_PERSON), 7f),
                new VideoGame("A horrendous game", BigDecimal.valueOf(5), Set.of(RPG, ACTION, THIRD_PERSON), 2f));
    }
}
