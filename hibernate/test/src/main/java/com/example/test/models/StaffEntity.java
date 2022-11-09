package com.example.test.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "staff", schema = "managementshop")
public class StaffEntity {
    private int idstaff;
    private String name;
    private String phonenumber;
    private String address;
    private Double salary;

    @Id
    @Column(name = "idstaff", nullable = false)
    public int getIdstaff() {
        return idstaff;
    }

    public void setIdstaff(int idstaff) {
        this.idstaff = idstaff;
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

    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return idstaff == that.idstaff && Objects.equals(name, that.name) && Objects.equals(phonenumber, that.phonenumber) && Objects.equals(address, that.address) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idstaff, name, phonenumber, address, salary);
    }
}
