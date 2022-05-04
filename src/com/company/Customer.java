package com.company;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Customer extends Company{
    private BigDecimal discount;

    public Customer(String companyName, String street, String city, String zipCode, BigDecimal discount) {
        super(companyName, street, city, zipCode);
        this.discount = discount;
    }

    public Customer() {
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
