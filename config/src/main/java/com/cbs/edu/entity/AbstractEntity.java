package com.cbs.edu.entity;

import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Data
public class AbstractEntity {

    /**
     * https://www.baeldung.com/hibernate-identifiers
     * https://docs.jboss.org/hibernate/orm/5.0/mappingGuide/en-US/html/ch06.html#identifiers-generators-generic
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    /*@GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )*/
    protected Integer id;

    @Version
    protected Integer version;
}