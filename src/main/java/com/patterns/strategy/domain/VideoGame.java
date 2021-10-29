package com.patterns.strategy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoGame {
    private String name;
    private BigDecimal price;
    private Set<Genre> genres;
    private Float rating;
}
