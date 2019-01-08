package com.cbs.edu.id_generation_strategies.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "table_strategy_entity_3")
@Data
@NoArgsConstructor
public class TableStrategyEntity3 {

    @Id
    @TableGenerator(
            name = "seqStore2",
            table = "SEQ_STORE",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "TableStrategyEntity3.ID",
            valueColumnName = "SEQ_VALUE",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seqStore2")
    private Long id;

    private String name;

    public TableStrategyEntity3(String name) {
        this.name = name;
    }
}
