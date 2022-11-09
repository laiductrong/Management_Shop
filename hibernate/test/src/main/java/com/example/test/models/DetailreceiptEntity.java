package com.example.test.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detailreceipt", schema = "managementshop")
public class DetailreceiptEntity {
    private Double amount;
    private Double unitprice;
    private Double totalprice;
    private int iddetailreceipt;

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "unitprice", nullable = true, precision = 0)
    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "totalprice", nullable = true, precision = 0)
    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    @Id
    @Column(name = "iddetailreceipt", nullable = false)
    public int getIddetailreceipt() {
        return iddetailreceipt;
    }

    public void setIddetailreceipt(int iddetailreceipt) {
        this.iddetailreceipt = iddetailreceipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailreceiptEntity that = (DetailreceiptEntity) o;
        return iddetailreceipt == that.iddetailreceipt && Objects.equals(amount, that.amount) && Objects.equals(unitprice, that.unitprice) && Objects.equals(totalprice, that.totalprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unitprice, totalprice, iddetailreceipt);
    }
}
