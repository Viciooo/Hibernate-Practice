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
//            Category category = new Category("AGD");
//            Query query1 = session.createQuery("From Product where ProductID = 3");
//            Product product = (Product) query1.getResultList().get(0);
            Query query = session.createQuery("From Category where CategoryID = 5");
            List categories = query.getResultList();
            for(Object category: categories){
                System.out.println(((Category)category).getName());
                for(Product product: ((Category) category).getProducts()){
                    System.out.println(product.getProductName());
                }
            }
//            Category category = (Category)query.getResultList().get(0);
//            category.getProducts().add(category.getProducts().size(),product);
//            System.out.println(category);
//            Transaction tx = session.beginTransaction();

//            session.save(category);
//            tx.commit();
        }
    }
}