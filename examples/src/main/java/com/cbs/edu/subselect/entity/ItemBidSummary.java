package com.cbs.edu.subselect.entity;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(
        value = "SELECT item.id AS itemId, item.item_name AS name, " +
                "COUNT(bid.id) AS numberOfBids " +
                "FROM \"item\" item LEFT JOIN \"bid\" bid " +
                "ON item.id = bid.item_id " +
                "GROUP BY item.id, item.item_name"
)
@Synchronize({"Item", "Bid"})
@Data
public class ItemBidSummary {

    @Id
    protected Long itemId;

    protected String name;

    protected long numberOfBids;

    public ItemBidSummary() {
    }
}