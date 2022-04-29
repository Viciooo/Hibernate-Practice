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
            Query query = session.createQuery("From Product");
            List products = query.getResultList();
            for (Object product: products){
                Set<Invoice> invoices = ((Product) product).getInvoices();
                for (Invoice invoice : invoices){
                    System.out.println(invoice.getInvoiceNumber());
                }
                System.out.println(((Product)product).getProductName());
                System.out.println("*******************");
            }
        }
    }
}