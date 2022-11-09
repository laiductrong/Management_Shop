package com.example.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "receipt", schema = "managementshop")
public class ReceiptEntity {
    private int idreceipt;

    @Id
    @Column(name = "idreceipt", nullable = false)
    public int getIdreceipt() {
        return idreceipt;
    }

    public void setIdreceipt(int idreceipt) {
        this.idreceipt = idreceipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptEntity that = (ReceiptEntity) o;
        return idreceipt == that.idreceipt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idreceipt);
    }
}
