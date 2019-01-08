package com.cbs.edu.subselect.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
@Data
@EqualsAndHashCode(callSuper = true)
public class Item extends AbstractEntity {

}
