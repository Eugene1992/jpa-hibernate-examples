package com.cbs.edu.immutable.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class Book extends AbstractEntity {

    @Column
    @Basic(optional = false, fetch = FetchType.LAZY)
    private String name;

    @Immutable
    @OneToMany(mappedBy = "book")
    private List<Page> pages;

    @Immutable
    @ElementCollection
    private Collection<String> tags = new ArrayList<>();
}
