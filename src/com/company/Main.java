package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class Main {
    public static void main(final String[] args)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        Customer customer = new Customer("alaMaKota","Makowa","Krakow","31-231",new BigDecimal("22.13"));
        em.persist(customer);
        Supplier supplier = new Supplier("alaNieMaKota","Makowa","Krakow","31-231","123455553434");
        em.persist(supplier);
        etx.begin();
        etx.commit();
        em.close();

    }
}