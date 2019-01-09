package com.cbs.edu.column_annotation_params.entity;

import com.cbs.edu.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Immutable
public class Human extends AbstractEntity {

    @Column(name = "first_name",
            unique = true,
            nullable = false)
    private String name;

    @Column(length = 10,
            updatable = false)
    private String lastName;

    @Column(insertable = false)
    private Integer age;

    @Column/*(table = "a")*/
    private Integer salary;

    /**
     * Precision is the number of digits in a number.
     * For example, the number 123.45 has a precision of 5 and a scale of 2.
     */
    @Column(columnDefinition = "Decimal(3,2) default '0.00'") // default for BigDecimal java type would be NUMERIC(3, 2)
    private BigDecimal height;

    /**
     * Scale is the number of digits to the right of the decimal point in a number.
     * For example, the number 123.45 has a precision of 5 and a scale of 2.
     */
    @Column(precision = 5,
            scale = 3)
    private BigDecimal weight;
}
