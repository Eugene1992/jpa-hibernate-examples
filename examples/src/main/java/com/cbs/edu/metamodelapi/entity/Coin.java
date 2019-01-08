package com.cbs.edu.metamodelapi.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coins")
@Data
@EqualsAndHashCode(callSuper = true)
public class Coin extends AbstractEntity {
    private Integer value;
}