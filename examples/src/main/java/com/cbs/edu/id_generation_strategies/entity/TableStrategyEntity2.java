package com.cbs.edu.id_generation_strategies.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "table_strategy_entity_2")
@Data
@NoArgsConstructor
public class TableStrategyEntity2 {

    @Id
    @TableGenerator(
            name = "seqStore1",
            table = "SEQ_STORE",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "TableStrategyEntity2.ID",
            valueColumnName = "SEQ_VALUE",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqStore1")
    private Long id;

    private String name;

    public TableStrategyEntity2(String name) {
        this.name = name;
    }
}
