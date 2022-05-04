package com.company;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProductID;
    private String ProductName;

    private Integer UnitsOnStock;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SupplierID", nullable = false)
    private Supplier supplier;

    @ManyToMany(mappedBy = "products",cascade = CascadeType.PERSIST)
    private Set<Invoice> invoices = new HashSet<>();

    public void sellProduct(int quantity, Invoice invoice) {
        // nie jestem pewny czy o to chodzi, ale to mało istotne, bo zadanie ma sprawdzać inne rzeczy
        if (quantity > 0 && this.UnitsOnStock >= quantity) {
            UnitsOnStock -= quantity;
            invoice.setQuantity(invoice.getQuantity() + quantity);
            invoice.getProducts().add(this);
        }
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Product(String productName, Integer unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getUnitsOnStock() {
        return UnitsOnStock;
    }

    public void setUnitsOnStock(Integer unitsOnStock) {
        UnitsOnStock = unitsOnStock;
    }

    public Product() {
    }
}
