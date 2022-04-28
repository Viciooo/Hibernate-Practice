package com.company;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {

        try (Session session = getSession()) {
//            Product product = new Product("Table",10);
//            Supplier supplier = new Supplier("OoohBi","Krakowska","Krakow");
            Transaction tx = session.beginTransaction();
//            session.save(supplier);
//            session.save(product);
            Query query = session.createQuery(" From Supplier");
            List results = query.getResultList();
            for (Object result : results) {
                Set<Product> productSet = ((Supplier)result).getProducts();
                for(Product product:productSet){
                    System.out.println(product.getProductName());
                }
            }
//            tx.commit();
        }
    }
}