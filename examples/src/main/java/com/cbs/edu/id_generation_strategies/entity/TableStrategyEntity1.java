package com.cbs.edu.id_generation_strategies.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "table_strategy_entity_1")
@Data
@NoArgsConstructor
public class TableStrategyEntity1 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    public TableStrategyEntity1(String name) {
        this.name = name;
    }
}
