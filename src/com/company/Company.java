package com.company;

import javax.persistence.*;

@Entity
@SecondaryTable(name="Address")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CompanyID;
    private String CompanyName;

    @Column(table = "Address")
    private String Street;
    @Column(table = "Address")
    private String City;
    @Column(table = "Address")
    private String ZipCode;

    public Company(String companyName, String street, String city, String zipCode) {
        CompanyName = companyName;
        Street = street;
        City = city;
        ZipCode = zipCode;
    }

    public Company() {
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int companyID) {
        CompanyID = companyID;
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

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }
}
