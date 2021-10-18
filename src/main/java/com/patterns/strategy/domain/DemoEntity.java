package com.patterns.strategy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity {
    private String name;
    private Long amount;
    private Status status;
}