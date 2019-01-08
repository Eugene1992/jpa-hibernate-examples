package com.cbs.edu.subselect;

import com.cbs.edu.config.JPAUtil;
import com.cbs.edu.subselect.entity.Bid;
import com.cbs.edu.subselect.entity.Item;
import com.cbs.edu.subselect.entity.ItemBidSummary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class TestRun {

    private static EntityManager entityManager;
    private static EntityTransaction transaction;

    @Before
    public void setUp() {
        entityManager = JPAUtil.getEntityManager("sub_select");
        transaction = entityManager.getTransaction();
        transaction.begin();

        Item item1 = new Item("Mona Liza");
        Item item2 = new Item("Picasso");

        entityManager.persist(item1);
        entityManager.persist(item2);

        Arrays.asList(
                new Bid(20_0000_000, item1),
                new Bid(10_0000_000, item1),
                new Bid(22_0000_000, item2),
                new Bid(12_0000_000, item2),
                new Bid(1_0000_000, item2)
        ).forEach(
                bid -> entityManager.persist(bid)
        );
    }

    @Test
    public void testSubSelect() {
        ItemBidSummary itemBidSummary = entityManager.find(ItemBidSummary.class, 1L);
        System.out.println(itemBidSummary);

        entityManager.persist(itemBidSummary);
    }

    @After
    public void endUp() {
        transaction.commit();
        entityManager.close();
        JPAUtil.close();
    }
}
