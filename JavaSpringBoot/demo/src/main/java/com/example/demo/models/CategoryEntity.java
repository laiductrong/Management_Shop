package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    private String idcategory;

    public String getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }

    public CategoryEntity(String idcategory) {
        this.idcategory = idcategory;
    }
    public CategoryEntity(){

    }
}
