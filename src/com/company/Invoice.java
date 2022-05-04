package com.company;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceID;

    private String InvoiceNumber;
    private int Quantity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Invoice(String invoiceNumber, int quantity) {
        InvoiceNumber = invoiceNumber;
        Quantity = quantity;
    }

    public Invoice() {
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        InvoiceID = invoiceID;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
