package com.cbs.edu.id_generation_strategies.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "auto_strategy_entity")
@Data
@NoArgsConstructor
public class AutoStrategyEntity {

    @Id
//    @GeneratedValue
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public AutoStrategyEntity(String name) {
        this.name = name;
    }
}
