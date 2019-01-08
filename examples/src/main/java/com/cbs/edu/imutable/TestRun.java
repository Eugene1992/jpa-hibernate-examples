package com.cbs.edu.imutable;

import com.cbs.edu.config.JPAUtil;
import com.cbs.edu.imutable.entity.Book;
import com.cbs.edu.imutable.entity.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestRun {

    private static EntityManager entityManager;
    private static EntityTransaction transaction;
    private static Book book;

    @Before
    public void setUp() {
        entityManager = JPAUtil.getEntityManager("immutable");
        transaction = entityManager.getTransaction();
        transaction.begin();

        book = new Book("World and Peace", null);

        entityManager.persist(book);

        List<Page> pages = Stream.of(
                new Page(1, book),
                new Page(2, book),
                new Page(3, book),
                new Page(4, book),
                new Page(5, book)
        )
                .peek(bid -> entityManager.persist(bid))
                .collect(toList());

        book.setPages(pages);
        entityManager.persist(book);
    }

    @Test
    public void testBookImmutable() {
        book.setName("World and Peace 2th edition");
        entityManager.persist(book);
    }

    @Test
    public void testPagesCollectionImmutable() {
        Page sixthPage = new Page(6, book);
        entityManager.persist(sixthPage);
    }

    @After
    public void endUp() {
        transaction.commit();
        entityManager.close();
        JPAUtil.close();
    }
}

