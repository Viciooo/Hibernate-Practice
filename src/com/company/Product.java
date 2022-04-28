package com.company;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int ProductID;
    private String ProductName;

    private Integer UnitsOnStock;

    @ManyToOne
    @JoinColumn(name="SupplierID",nullable = false)
    private Supplier supplier;

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

    public Product(){}
}
