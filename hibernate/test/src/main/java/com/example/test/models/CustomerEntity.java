package com.example.test.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "managementshop")
public class CustomerEntity {
    private int idcustomer;
    private String name;
    private String phonenumber;
    private String address;

    @Id
    @Column(name = "idcustomer", nullable = false)
    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phonenumber", nullable = true, length = 45)
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return idcustomer == that.idcustomer && Objects.equals(name, that.name) && Objects.equals(phonenumber, that.phonenumber) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcustomer, name, phonenumber, address);
    }
}
