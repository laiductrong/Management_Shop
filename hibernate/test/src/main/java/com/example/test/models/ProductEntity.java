package com.example.test.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "managementshop")
public class ProductEntity {
    private String idproduct;
    private String price;
    private String infor;

    @Id
    @Column(name = "idproduct", nullable = false, length = 45)
    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 45)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "infor", nullable = true, length = 100)
    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(idproduct, that.idproduct) && Objects.equals(price, that.price) && Objects.equals(infor, that.infor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, price, infor);
    }
}
