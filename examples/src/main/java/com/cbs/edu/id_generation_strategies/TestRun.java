package com.cbs.edu.id_generation_strategies;

import com.cbs.edu.config.JPAUtil;
import com.cbs.edu.id_generation_strategies.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TestRun {

    private static EntityManager entityManager;
    private static EntityTransaction transaction;

    @Before
    public void setUp() {
        entityManager = JPAUtil.getEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @Test
    public void testAutoStrategy() {
        AutoStrategyEntity autoStrategyEntity = new AutoStrategyEntity("Some name for AutoStrategyEntity");
        entityManager.persist(autoStrategyEntity);
    }

    @Test
    public void testIdentityStrategy() {
        IdentityStrategyEntity identityStrategyEntity = new IdentityStrategyEntity("Some name for IdentityStrategyEntity");
        entityManager.persist(identityStrategyEntity);
    }

    @Test
    public void testSequenceStrategy() {
        SequenceStrategyEntity sequenceStrategyEntity = new SequenceStrategyEntity("Some name for SequenceStrategyEntity");
        entityManager.persist(sequenceStrategyEntity);
    }

    @Test
    public void testTableStrategy() {
        TableStrategyEntity1 tableStrategyEntity1 = new TableStrategyEntity1("Some name for TableStrategyEntity2");
        TableStrategyEntity2 tableStrategyEntity2 = new TableStrategyEntity2("Some name for TableStrategyEntity2");
        TableStrategyEntity3 tableStrategyEntity3 = new TableStrategyEntity3("Some name for TableStrategyEntity2");

        entityManager.persist(tableStrategyEntity1);
        entityManager.persist(tableStrategyEntity2);
        entityManager.persist(tableStrategyEntity3);
    }

    @After
    public void endUp() {
        transaction.commit();
        entityManager.close();
        JPAUtil.close();
    }
}
