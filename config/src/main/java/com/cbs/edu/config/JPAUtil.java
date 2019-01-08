package com.cbs.edu.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emFactory;

    public static EntityManager getEntityManager(String name) {
        if (emFactory == null) {
            try {
                emFactory = Persistence.createEntityManagerFactory(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return emFactory.createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

    public static void close() {
        emFactory.close();
    }
}