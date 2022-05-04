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
        Invoice invoice = new Invoice("test3",0);
//        Product product = (Product) em.createQuery("FROM Product WHERE ProductID=1").getResultList().get(0);
        Product product = new Product("testProduct3",10);
        product.setSupplier((Supplier) em.createQuery("FROM Supplier WHERE SupplierID=1").getResultList().get(0));
        product.setUnitsOnStock(product.getUnitsOnStock()-1);
        product.getInvoices().add(invoice);
        product.getInvoices().iterator().next().setQuantity(1);
//        invoice.getProducts().add(product);
//        invoice.setQuantity(1);
//        em.persist(invoice);
        em.persist(product);
        etx.begin();
        etx.commit();
        em.close();

    }
}