package com.company;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SupplierID;
    private String CompanyName;
    private String Street;
    private String City;


    @OneToMany(mappedBy="supplier")
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "SupplierProducts",
//            joinColumns = @JoinColumn(name = "SupplierID"),
//            inverseJoinColumns = @JoinColumn(name = "ProductID")
//    )
//    private Set<Product> products;
//    public Set<Product> getProducts() { return products;}
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
    public Supplier() {
    }

    public Supplier(String companyName, String street, String city) {
        CompanyName = companyName;
        Street = street;
        City = city;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int supplierID) {
        SupplierID = supplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}

