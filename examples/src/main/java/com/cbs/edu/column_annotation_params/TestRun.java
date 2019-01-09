package com.cbs.edu.column_annotation_params;

import com.cbs.edu.column_annotation_params.entity.Human;
import com.cbs.edu.config.JPAUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

/**
 * https://www.mkyong.com/hibernate/hibernate-mutable-example-class-and-collection/
 * http://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/
 */
public class TestRun {

    private static EntityManager entityManager;
    private static EntityTransaction transaction;
    private static Human human = new Human(
            "Ivan",
            "Ivanovich",
            22,
            20000,
            new BigDecimal("1.81432"),
            new BigDecimal("95.3254231")
    );

    @Before
    public void setUp() {
        entityManager = JPAUtil.getEntityManager("column_annotation_params");
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @Test
    public void testHumanPersist() {
        entityManager.persist(human);
    }

    @Test
    public void testHumanWithTooLongLastNamePersist() {
        human.setLastName("Ivanooooooooooooooooooovich");
        entityManager.persist(human);
    }

    @After
    public void endUp() {
        transaction.commit();
        entityManager.close();
        JPAUtil.close();
    }
}

