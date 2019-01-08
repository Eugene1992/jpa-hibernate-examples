package com.cbs.edu.imutable.entity;

import com.cbs.edu.entity.AbstractEntity;
import com.cbs.edu.subselect.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class Book extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "book")
    private List<Page> pages;
}
