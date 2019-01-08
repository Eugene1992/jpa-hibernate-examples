package com.cbs.edu.metamodelapi.entity;

import com.cbs.edu.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager("");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Coin coin = new Coin();
        coin.setValue(100);

        entityManager.persist(coin);

        Metamodel metamodel = JPAUtil.getEntityManagerFactory().getMetamodel();

        Set<EntityType<?>> entities = metamodel.getEntities();

        entities.forEach(
                entity -> {
                    System.out.println("Entity name: " + entity.getName());
                    SingularAttribute valueAttr = entity.getSingularAttribute(("value"));
                    System.out.println("Value field Java type: " + valueAttr.getJavaType().getName());
                    System.out.println("Is collection: " + valueAttr.isCollection());
                    System.out.println("Is association: " + valueAttr.isAssociation());
                }
        );

        transaction.commit();
        entityManager.close();
        JPAUtil.close();
    }
}