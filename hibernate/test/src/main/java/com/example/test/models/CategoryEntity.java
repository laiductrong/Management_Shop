package com.example.test.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "managementshop")
public class CategoryEntity {
    private String idcategory;

    @Id
    @Column(name = "idcategory", nullable = false, length = 45)
    public String getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(idcategory, that.idcategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategory);
    }
}
