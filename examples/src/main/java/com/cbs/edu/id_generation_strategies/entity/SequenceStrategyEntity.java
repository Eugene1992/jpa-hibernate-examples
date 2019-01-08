package com.cbs.edu.id_generation_strategies.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sequence_strategy_entity")
@Data
@NoArgsConstructor
public class SequenceStrategyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public SequenceStrategyEntity(String name) {
        this.name = name;
    }
}
