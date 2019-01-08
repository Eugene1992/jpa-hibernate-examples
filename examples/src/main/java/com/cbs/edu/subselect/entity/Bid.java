package com.cbs.edu.subselect.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "BIDS")
@Data
@EqualsAndHashCode(callSuper = true)
public class Bid extends AbstractEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    protected Item item;
}
