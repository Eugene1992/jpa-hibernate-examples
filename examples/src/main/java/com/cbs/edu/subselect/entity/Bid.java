package com.cbs.edu.subselect.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Bid extends AbstractEntity {

    private Integer value;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    protected Item item;
}
