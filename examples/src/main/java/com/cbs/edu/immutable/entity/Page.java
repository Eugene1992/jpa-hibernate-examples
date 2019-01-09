package com.cbs.edu.immutable.entity;

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
public class Page extends AbstractEntity {

    private Integer number;

    @ManyToOne
    @JoinColumn(name = "book_id")
    protected Book book;
}
