package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(final String[] args)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        Supplier supplier = new Supplier("CEO","Olszanska","Krakow");
        em.persist(supplier);
        etx.begin();
        etx.commit();
        em.close();

    }
}